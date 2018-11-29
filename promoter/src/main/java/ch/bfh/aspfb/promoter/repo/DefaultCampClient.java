package ch.bfh.aspfb.promoter.repo;

import ch.bfh.aspfb.promoter.model.Party;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DefaultCampClient implements CampClient {

    @Override
    public Resource<Party> createParty(String name) {
        Party p = new Party();
        p.setName(name);
        ResponseEntity<Resource<Party>> response = new RestTemplate().exchange(
                "http://localhost:8081/parties/dynamicPartyCreation",
                HttpMethod.POST,
                new HttpEntity<>(p),
                new ParameterizedTypeReference<Resource<Party>>() {
                },
                name);
        return response.getBody();
    }
}
