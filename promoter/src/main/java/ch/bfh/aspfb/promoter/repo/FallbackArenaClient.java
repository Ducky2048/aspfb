package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Party;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FallbackArenaClient implements ArenaClient {

    @Override
    public String battle(List<Party> challangers) {
        return "The fight is a draw since the arena is closed. come back tomorrow";
    }
}