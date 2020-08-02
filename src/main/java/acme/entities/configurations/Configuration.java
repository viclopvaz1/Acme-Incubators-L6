
package acme.entities.configurations;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Configuration extends DomainEntity {

	public static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				spamWords;

	@Min(0)
	@Max(100)
	@NotNull
	private Double				spamThreshold;

	@NotBlank
	private String				sectors;

}
