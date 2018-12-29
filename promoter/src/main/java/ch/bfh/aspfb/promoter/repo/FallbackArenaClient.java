package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.config.MessageProperties;
import ch.bfh.aspfb.promoter.model.Party;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FallbackArenaClient implements ArenaClient {

    @Autowired
    private MessageProperties messages;

    @Override
    public String battle(List<Party> challangers) {
        return messages.getArenaFallback();
    }
}