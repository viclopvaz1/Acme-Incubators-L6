
package acme.components;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class FormatterRegistrar implements WebMvcConfigurer {

	@Override
	public void addFormatters(final FormatterRegistry registry) {
		EmailFormatter phoneFormatter;

		phoneFormatter = new EmailFormatter();
		registry.addFormatter(phoneFormatter);
	}

}
