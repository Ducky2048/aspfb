package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Party;

public interface CampRepo {
    Party createParty(final String name);
}
