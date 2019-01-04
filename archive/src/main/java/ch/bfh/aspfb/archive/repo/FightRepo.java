package ch.bfh.aspfb.archive.repo;

import ch.bfh.aspfb.archive.model.Fight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FightRepo extends MongoRepository<Fight, String> {
}
