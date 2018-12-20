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

    private final CampClient campClient;

    @Autowired
    public DefaultCampRepo(CampClient campClient) {
        this.campClient = campClient;
    }

    @Override
    public Party createParty(String name) {
        Resource<Party> partyResource = campClient.createParty(name);
        Party party = partyResource.getContent();
        List<Hero> members = new ArrayList<>(campClient.getPartyMembers(party.getId()).getContent());
        party.setMembers(members);
        return party;
    }
}
