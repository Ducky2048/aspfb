package ch.bfh.aspfb.arena.service;

import ch.bfh.aspfb.arena.model.Party;

public interface BattleService {
    public String battle(Party challengeeParty, Party challengerParty);
}
