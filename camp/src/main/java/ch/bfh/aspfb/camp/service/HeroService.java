package ch.bfh.aspfb.camp.service;

import ch.bfh.aspfb.camp.model.Hero;

public interface HeroService {
    Hero createHero(String name);

    long getStrongHeroCount();
}
