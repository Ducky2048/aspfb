package ch.bfh.aspfb.heroes.rest.repository.impl;

import ch.bfh.aspfb.heroes.model.Hero;
import ch.bfh.aspfb.heroes.model.Party;
import ch.bfh.aspfb.heroes.rest.repository.CustomPartyRestRepository;
import ch.bfh.aspfb.heroes.rest.repository.PartyRestRepository;
import ch.bfh.aspfb.heroes.service.HeroService;
import ch.bfh.aspfb.heroes.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class CustomPartyRestRepositoryImpl implements CustomPartyRestRepository {
    @Autowired
    private PartyService partyService;

    @Autowired
    private PartyRestRepository partyRepository;

    @Autowired
    private HeroService heroService;


    @Override
    public void dynamicPartyCreation(final String name) {
        final Party party = this.partyService.createParty(name);
        final List<Hero> heroes = IntStream.range(0, 3)
                .mapToObj(i -> this.heroService.createHero(String.format("Hero %d for %s", i, name)))
                .collect(Collectors.toList());
        party.setMembers(heroes);
        this.partyRepository.save(party);
    }
}
