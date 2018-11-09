package ch.bfh.aspfb.heroes.rest.controller;

import ch.bfh.aspfb.heroes.model.Hero;
import ch.bfh.aspfb.heroes.model.Party;
import ch.bfh.aspfb.heroes.repository.PartyRepository;
import ch.bfh.aspfb.heroes.service.HeroService;
import ch.bfh.aspfb.heroes.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RepositoryRestController
@Configuration
public class PartyController {
    @Autowired
    private PartyService partyService;

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private HeroService heroService;


    @RequestMapping(method = RequestMethod.POST, value = "/parties/dynamicPartyCreation")
    public @ResponseBody
    ResponseEntity<PersistentEntityResource> dynamicPartyCreation(
            @RequestBody(required = true) Resource<Party> partyResource,
            PersistentEntityResourceAssembler persistentEntityResourceAssembler) {
        if (partyResource == null || partyResource.getContent().getName() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        final Party party = this.partyService.createParty(partyResource.getContent().getName());
        final List<Hero> heroes = IntStream.range(0, 3)
                .mapToObj(i -> this.heroService.createHero(String.format("Hero %d for %s", i, party.getName())))
                .collect(Collectors.toList());
        party.setMembers(heroes);
        this.partyRepository.save(party);
        return ResponseEntity.ok(persistentEntityResourceAssembler.toResource(party));
    }
}
