package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Hero;
import ch.bfh.aspfb.promoter.model.Party;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

@Component
public class CampClientFallback implements CampClient {
    private final Logger log = LoggerFactory.getLogger(CampClientFallback.class);

    @Override
    public Resource<Party> createParty(final String name) {
        log.info("Creating party from fallback");
        final Party party = new Party(name);
        party.setMembers(Collections.emptyList());
        return new Resource<>(party);
    }

    @Override
    public Resources<Hero> getPartyMembers(String id) {
        log.info("Getting members from fallback");
        return new Resources<>(Collections.emptyList());
    }
}
