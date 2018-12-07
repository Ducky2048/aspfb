package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "camp", fallback = CampClientFallback.class)
public interface CampClient {

    @RequestMapping(method = RequestMethod.GET, value = "/parties/dynamicPartyCreation")
    Party createParty(final String name);
}
