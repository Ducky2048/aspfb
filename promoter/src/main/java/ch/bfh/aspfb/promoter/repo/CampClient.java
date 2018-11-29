package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Party;
import org.springframework.hateoas.Resource;

public interface CampClient {
    Resource<Party> createParty(String name);
}
