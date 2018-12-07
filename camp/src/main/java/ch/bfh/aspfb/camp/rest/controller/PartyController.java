package ch.bfh.aspfb.camp.rest.controller;

import ch.bfh.aspfb.camp.model.Hero;
import ch.bfh.aspfb.camp.model.Party;
import ch.bfh.aspfb.camp.rest.repository.PartyRestRepository;
import ch.bfh.aspfb.camp.service.HeroService;
import ch.bfh.aspfb.camp.service.PartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
@Configuration
public class PartyController {
    private static final Logger logger = LoggerFactory.getLogger(PartyController.class);

    @Autowired
    private PartyService partyService;

    @Autowired
    private PartyRestRepository partyRepository;

    @Autowired
    private HeroService heroService;

    @Autowired
    private RepositoryEntityLinks entityLinks;


    @RequestMapping(method = RequestMethod.GET, value = "/parties/dynamicPartyCreation")
    public Party dynamicPartyCreation(@NonNull @RequestParam final String name) {

        final Party party = this.partyService.createParty(name);

        party.add(linkTo(methodOn(PartyController.class).dynamicPartyCreation(name)).withSelfRel());

        party.setMembers(
                IntStream.range(0, 3)
                .mapToObj(i -> this.heroService.createHero(String.format("Hero %d for %s", i, party.getName())))
                .collect(Collectors.toList())
        );

        party.getMembers().forEach(h -> party.add(this.entityLinks.linkToSingleResource(Hero.class, h.getId())));
        return party;

    }
}
