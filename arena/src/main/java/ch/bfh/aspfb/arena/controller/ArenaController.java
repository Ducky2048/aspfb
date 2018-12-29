package ch.bfh.aspfb.arena.controller;

import ch.bfh.aspfb.arena.config.MessageConfiguration;
import ch.bfh.aspfb.arena.model.Party;
import ch.bfh.aspfb.arena.service.BattleService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.List;

@RestController
public class ArenaController {

    @Autowired
    private BattleService battleService;

    @Autowired
    private MessageConfiguration messages;

    @PostMapping(value = "/battle")
    public String battle(@RequestBody List<Party> challengers) {

        if (challengers.size() != 2) {
            throw new RuntimeException("Only 2 challengers at the same time are allowed in the arena.");
        }

        Party challengee = challengers.get(0);
        Party challenger = challengers.get(1);
        String winner = battleService.battle(challengee, challenger);
        return String.format(messages.getVictoryMessage(), challengee.getName(), challenger.getName(), winner);
    }
}
