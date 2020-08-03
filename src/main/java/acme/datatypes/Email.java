
package acme.datatypes;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.framework.datatypes.DomainDatatype;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Email extends DomainDatatype {

	private static final long	serialVersionUID	= 1L;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9.-]{1,64}$", message = "default.error.domain")
	private String				name;

	@NotNull
	@Pattern(regexp = "^[@][a-zA-Z]+([.][a-zA-Z]+)$", message = "default.error.domain")
	private String				domain;

	@Pattern(regexp = "^[a-zA-Z. -]+$", message = "default.error.domain")
	private String				displayName;


	@Override
	public String toString() {
		StringBuilder result;

		result = new StringBuilder();
		if (this.displayName == "") {
			result.append("");
			result.append(this.name);
			result.append(this.domain);
		} else {
			result.append(this.displayName);
			result.append(" <");
			result.append(this.name);
			result.append(this.domain);
			result.append("> ");
		}
		return result.toString();
	}

}
