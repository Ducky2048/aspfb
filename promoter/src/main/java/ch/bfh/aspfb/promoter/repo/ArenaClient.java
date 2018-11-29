package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Party;

import java.util.List;

public interface ArenaClient {
    String battle(List<Party> challangers);
}
