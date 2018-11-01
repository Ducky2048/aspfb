package ch.bfh.aspfb.heroes.repository;

import ch.bfh.aspfb.heroes.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<Hero, String> {
    long countHerosByAtkGreaterThan(int threshold);
}
