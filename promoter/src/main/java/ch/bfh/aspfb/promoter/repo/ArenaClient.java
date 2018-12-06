package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "arena", fallback = FallbackArenaClient.class)
public interface ArenaClient {

    @PostMapping(value = "/battle")
    String battle(@RequestBody List<Party> challangers);
}
