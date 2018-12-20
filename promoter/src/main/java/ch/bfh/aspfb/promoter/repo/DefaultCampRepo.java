package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Hero;
import ch.bfh.aspfb.promoter.model.Party;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class DefaultCampRepo implements CampRepo {
    private final Logger log = LoggerFactory.getLogger(CampRepo.class);

    private final CampClient campClient;

    @Autowired
    public DefaultCampRepo(CampClient campClient) {
        this.campClient = campClient;
    }

    @Override
    public Party createParty(String name) {
        Resource<Party> partyResource = campClient.createParty(name);
        Party party = partyResource.getContent();
        if (party.getMembers() != null)
            return party;
        Resources<Hero> partyMembers = campClient.getPartyMembers(party.getId());
        log.info("Members for party {} are: {}", party.getId(), partyMembers);
        List<Hero> members = new ArrayList(partyMembers.getContent());
//        List<Hero> members = getMembers(partyResource);
        party.setMembers(members);
        return party;
    }

//    private List<Hero> getMembers(Resource<Party> party) {
//        Link memberLink = party.getLink("members");
//        if(memberLink == null)
//            return Collections.emptyList();
//        ResponseEntity<Resources<Hero>> memberResources = restTemplate.exchange(memberLink.getHref(), HttpMethod.GET,
//                HttpEntity.EMPTY, new ParameterizedTypeReference<Resources<Hero>>() {});
//        return new ArrayList<>(memberResources.getBody().getContent());
//    }
}
