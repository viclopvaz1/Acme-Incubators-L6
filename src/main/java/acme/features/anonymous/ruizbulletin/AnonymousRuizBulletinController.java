
package acme.features.anonymous.ruizbulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.ruizbulletins.ruizBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/ruiz-bulletin/")
public class AnonymousRuizBulletinController extends AbstractController<Anonymous, ruizBulletin> {

	@Autowired
	private AnonymousRuizBulletinListService		listService;

	@Autowired
	private AnonymousRuizBulletinCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
