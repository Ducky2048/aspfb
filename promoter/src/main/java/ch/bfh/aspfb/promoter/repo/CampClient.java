package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Hero;
import ch.bfh.aspfb.promoter.model.Party;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "heroes-camp", fallback = CampClientFallback.class)
public interface CampClient {

    @GetMapping(value = "/parties/dynamicPartyCreation")
    Resource<Party> createParty(@RequestParam("name") final String name);

    @GetMapping(path = "/parties/{id}/members")
    Resources<Hero> getPartyMembers(@PathVariable("id") String id);
}
