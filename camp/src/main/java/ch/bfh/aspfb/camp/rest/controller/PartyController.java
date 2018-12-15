package ch.bfh.aspfb.camp.rest.controller;

import ch.bfh.aspfb.camp.model.Party;
import ch.bfh.aspfb.camp.rest.repository.PartyRestRepository;
import ch.bfh.aspfb.camp.service.PartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
@RequestMapping(value = "/parties")
public class PartyController {
    private static final Logger logger = LoggerFactory.getLogger(PartyController.class);

    @Autowired
    private PartyService partyService;

    @GetMapping(value = "/dynamicPartyCreation")
    public @ResponseBody ResponseEntity<?> dynamicPartyCreation(@NonNull @RequestParam final String name, PersistentEntityResourceAssembler assembler) {
        final Party party = this.partyService.createParty(name);
        return ResponseEntity.ok(assembler.toResource(party));
    }
}
