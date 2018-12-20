package ch.bfh.aspfb.promoter.service;

import ch.bfh.aspfb.promoter.model.Party;
import ch.bfh.aspfb.promoter.repo.ArenaClient;
import ch.bfh.aspfb.promoter.repo.CampRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultPromoterService implements PromoterService {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultPromoterService.class);

    @Autowired
    private CampRepo campRepo;

    @Autowired
    private ArenaClient arenaClient;

    @Override
    public String promoteFight() {
        Party challengee = campRepo.createParty("Challengee");
        Party challenger = campRepo.createParty("Challenger");
        LOG.info("Todays battle is between Party '" + challengee.getName() + "' and Party '" + challenger.getName() + "'.");
        LOG.info("{} : {}", challenger, challengee);

        List<Party> challangers = new ArrayList<>();
        challangers.add(challengee);
        challangers.add(challenger);
        String winner = arenaClient.battle(challangers);
        LOG.info("And the winner is: Party '" + winner + "'");

        return winner;
    }
}
