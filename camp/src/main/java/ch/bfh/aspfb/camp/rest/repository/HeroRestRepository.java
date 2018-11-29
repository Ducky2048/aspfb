package ch.bfh.aspfb.camp.rest.repository;

import ch.bfh.aspfb.camp.model.Hero;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface HeroRestRepository extends PagingAndSortingRepository<Hero, String> {
    long countHerosByAtkGreaterThan(int threshold);
}
