package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Party;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Resource;

import java.util.Collections;


public class CampClientFallback implements CampClient {
    private final Logger log = LoggerFactory.getLogger(CampClientFallback.class);

    @Override
    public Party createParty(Party party) {
        log.info("Creating party from fallback");
        party.setMembers(Collections.emptyList());
        return party;
    }
}
