
package acme.components;

import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.format.Formatter;

import acme.datatypes.Email;
import acme.framework.helpers.MessageHelper;
import acme.framework.helpers.StringHelper;

public class EmailFormatter implements Formatter<Email> {

	@Override
	public String print(final Email object, final Locale locale) {
		assert object != null;
		assert locale != null;

		String result;
		String nameText, domainText, displayNameText;

		nameText = String.format("%s", object.getName());
		displayNameText = object.getDisplayName() == null ? " " : String.format(" (%s) ", object.getDisplayName());
		domainText = String.format("%s", object.getDomain());

		result = String.format("+%s%s%s", displayNameText, nameText, domainText);

		return result;
	}

	@Override
	public Email parse(final String text, final Locale locale) throws ParseException {
		assert !StringHelper.isBlank(text);
		assert locale != null;

		Email result;
		String displayNameRegex, nameRegex, domainRegex, emailRegex;
		Pattern pattern;
		Matcher matcher;
		String errorMessage;

		String displayName, name, domain;

		displayNameRegex = "[a-zA-Z. -]+";
		nameRegex = "[a-zA-Z0-9.-]{1,64}";
		domainRegex = "[@][a-zA-Z]+([.][a-zA-Z]+)";
		emailRegex = String.format(//
			"^(?<DN>%1$s)?(<?(?<N>%2$s)(?<D>%3$s)+>?)?$",//
			displayNameRegex, nameRegex, domainRegex);

		pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		matcher = pattern.matcher(text);

		if (!matcher.find()) {
			errorMessage = MessageHelper.getMessage("default.error.conversion", null, "Invalid value", locale);
			throw new ParseException(errorMessage, 0);
		} else {
			displayName = matcher.group("DN");
			name = matcher.group("N");
			domain = matcher.group("D");

			result = new Email();
			result.setDisplayName(displayName);
			result.setName(name);
			result.setDomain(domain);
		}

		return result;
	}

}
