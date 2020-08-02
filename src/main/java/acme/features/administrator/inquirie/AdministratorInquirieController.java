
package acme.features.administrator.inquirie;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.inquiries.Inquirie;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/inquirie/")
public class AdministratorInquirieController extends AbstractController<Administrator, Inquirie> {

	@Autowired
	private AdministratorInquirieDeleteService	deleteService;

	@Autowired
	private AdministratorInquirieUpdateService	updateService;

	@Autowired
	private AdministratorInquirieCreateService	createService;

	@Autowired
	private AdministratorInquirieListService	listService;

	@Autowired
	private AdministratorInquirieShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}

}
