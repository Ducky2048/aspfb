package ch.bfh.aspfb.heroes.repository;

import ch.bfh.aspfb.heroes.model.Party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends CrudRepository<Party, String> {
}
