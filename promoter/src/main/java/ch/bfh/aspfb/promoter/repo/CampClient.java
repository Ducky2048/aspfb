package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "camp", fallback = CampClientFallback.class)
public interface CampClient {

    @GetMapping(value = "/dynamicPartyCreation")
    Party createParty(@RequestParam("name") final String name);
}
