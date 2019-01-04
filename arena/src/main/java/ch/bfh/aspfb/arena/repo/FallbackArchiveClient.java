package ch.bfh.aspfb.arena.repo;

import ch.bfh.aspfb.arena.model.Fight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class FallbackArchiveClient implements ArchiveClient {
    private final Logger log = LoggerFactory.getLogger(FallbackArchiveClient.class);


    @Override
    public Fight archiveFight(Fight result) {
        log.error("Archiving fight failed because archive service is down");
        result.setId("");
        return result;
    }
}
