package ch.bfh.aspfb.camp.rest.repository;

import ch.bfh.aspfb.camp.model.Party;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PartyRestRepository extends PagingAndSortingRepository<Party, String> {
}
