package ch.bfh.aspfb.heroes.service;

import ch.bfh.aspfb.heroes.model.Hero;

public interface HeroService {
    Hero createHero(String name);

    long getStrongHeroCount();
}
