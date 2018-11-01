package ch.bfh.aspfb.repository;

import ch.bfh.aspfb.model.Party;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends CrudRepository<Party, String> {
}
