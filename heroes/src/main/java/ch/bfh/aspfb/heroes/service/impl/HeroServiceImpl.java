package ch.bfh.aspfb.heroes.service.impl;


import ch.bfh.aspfb.heroes.model.Hero;
import ch.bfh.aspfb.heroes.repository.HeroRepository;
import ch.bfh.aspfb.heroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HeroServiceImpl implements HeroService {
    private Random random = new Random();

    private final HeroRepository heroRepository;

    @Autowired
    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }


    public Hero createHero(final String name) {
        final Hero hero = new Hero();
        hero.setName(name);
        hero.setAtk(random.nextInt(100));
        hero.setDef(random.nextInt(100));
        hero.setHp(100);
        System.out.println(String.format("Created hero: %s", hero.toString()));
        return heroRepository.save(hero);
    }

    @Override
    public long getStrongHeroCount() {
        return heroRepository.countHerosByAtkGreaterThan(50);
    }
}
