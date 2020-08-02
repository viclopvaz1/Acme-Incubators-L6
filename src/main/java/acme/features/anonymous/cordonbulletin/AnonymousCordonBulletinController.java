
package acme.features.anonymous.cordonbulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.cordonbulletins.cordonBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/cordon-bulletin/")
public class AnonymousCordonBulletinController extends AbstractController<Anonymous, cordonBulletin> {

	@Autowired
	private AnonymousCordonBulletinListService	listService;

	@Autowired
	private AnonymousCordonBulletinCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
