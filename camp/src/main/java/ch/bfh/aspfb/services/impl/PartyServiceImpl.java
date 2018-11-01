package ch.bfh.aspfb.services.impl;

import ch.bfh.aspfb.model.Party;
import ch.bfh.aspfb.repository.PartyRepository;
import ch.bfh.aspfb.service.HeroService;
import ch.bfh.aspfb.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class PartyServiceImpl implements PartyService {
    @Autowired
    private HeroService heroService;

    @Autowired
    private PartyRepository partyRepository;

    public Party createParty(String name) {
        final Party party = new Party();
        party.setName(name);
        party.setMembers(IntStream.range(0, 4).mapToObj(i -> this.heroService.createHero(String.format("Le hero %d", i))).collect(Collectors.toList()));
        System.out.println(String.format("Created Party: %s", party.toString()));
        return partyRepository.save(party);
    }
}
