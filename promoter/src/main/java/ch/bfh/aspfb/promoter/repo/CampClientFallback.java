package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Party;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;


public class CampClientFallback implements CampClient {
    private final Logger log = LoggerFactory.getLogger(CampClientFallback.class);

    @Override
    public Party createParty(final String name) {
        log.info("Creating party from fallback");
        final Party party = new Party(name);
        party.setMembers(Collections.emptyList());
        return party;
    }
}
