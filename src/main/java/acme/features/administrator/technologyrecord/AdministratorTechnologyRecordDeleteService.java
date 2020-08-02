
package acme.features.administrator.technologyrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.technologyrecords.TechnologyRecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorTechnologyRecordDeleteService implements AbstractDeleteService<Administrator, TechnologyRecord> {

	@Autowired
	AdministratorTechnologyRecordRepository repository;


	@Override
	public boolean authorise(final Request<TechnologyRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<TechnologyRecord> request, final TechnologyRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<TechnologyRecord> request, final TechnologyRecord entity, final Model model) {
		assert request != null;
		assert request != null;
		assert request != null;

		request.unbind(entity, model, "description", "title", "sector", "name", "web", "email", "indication", "star");

	}

	@Override
	public TechnologyRecord findOne(final Request<TechnologyRecord> request) {
		assert request != null;

		TechnologyRecord result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<TechnologyRecord> request, final TechnologyRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<TechnologyRecord> request, final TechnologyRecord entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
	}

}
