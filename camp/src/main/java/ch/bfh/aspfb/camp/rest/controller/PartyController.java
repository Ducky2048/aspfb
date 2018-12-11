package ch.bfh.aspfb.camp.rest.controller;

import ch.bfh.aspfb.camp.model.Hero;
import ch.bfh.aspfb.camp.model.Party;
import ch.bfh.aspfb.camp.service.PartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class PartyController {
    private static final Logger logger = LoggerFactory.getLogger(PartyController.class);

    @Autowired
    private PartyService partyService;

    @Autowired
    private RepositoryEntityLinks entityLinks;


    @GetMapping(value = "/dynamicPartyCreation")
    public Party dynamicPartyCreation(@NonNull @RequestParam final String name) {

        final Party party = this.partyService.createParty(name);
        party.add(linkTo(methodOn(PartyController.class).dynamicPartyCreation(name)).withSelfRel());

        for(int i = 0; i < party.getMembers().size(); i++) {
            party.add(this.entityLinks.linkToSingleResource(Hero.class, party.getMembers().get(i).getId()).withRel(String.format("Hero no %d", i)));
        }

        return party;
    }
}
