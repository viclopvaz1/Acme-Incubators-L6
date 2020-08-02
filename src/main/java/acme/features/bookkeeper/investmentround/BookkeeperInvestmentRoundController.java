/*
 * EntrepreneurProviderController.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.bookkeeper.investmentround;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.investmentrounds.InvestmentRound;
import acme.entities.roles.Bookkeeper;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/bookkeeper/investment-round/")
public class BookkeeperInvestmentRoundController extends AbstractController<Bookkeeper, InvestmentRound> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private BookkeeperInvestmentRoundListMineService	listMineService;

	@Autowired
	private BookkeeperInvestmentRoundListNoMineService	listNoMineService;

	@Autowired
	private BookkeeperInvestmentRoundShowService		showService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		super.addCustomCommand(CustomCommand.LIST_NO_MINE, BasicCommand.LIST, this.listNoMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
