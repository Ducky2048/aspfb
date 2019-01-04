package ch.bfh.aspfb.arena.repo;

import ch.bfh.aspfb.arena.model.Fight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "heroes-archive", fallback = FallbackArchiveClient.class)
public interface ArchiveClient {

    @PostMapping(value = "/fights")
    Fight archiveFight(@RequestBody Fight result);
}
