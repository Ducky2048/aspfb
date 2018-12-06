package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Party;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class FallbackArenaClient implements ArenaClient {

    @Override
    public String battle(List<Party> challangers) {
        return "The fight is a draw since the arena is closed. come back tomorrow";
    }
}