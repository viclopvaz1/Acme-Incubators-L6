
package acme.features.patron.creditcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.creditcards.CreditCard;
import acme.entities.roles.Patron;
import acme.features.patron.banner.PatronBannerRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class PatronCreditCardDeleteService implements AbstractDeleteService<Patron, CreditCard> {

	@Autowired
	PatronCreditCardRepository	repository;

	@Autowired
	PatronBannerRepository		bannerRepository;


	@Override
	public boolean authorise(final Request<CreditCard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<CreditCard> request, final CreditCard entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<CreditCard> request, final CreditCard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "holderName", "number", "brand", "monthExp", "yearExp", "cvv");

	}

	@Override
	public CreditCard findOne(final Request<CreditCard> request) {
		assert request != null;

		CreditCard result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<CreditCard> request, final CreditCard entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<CreditCard> request, final CreditCard entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);

	}

}
