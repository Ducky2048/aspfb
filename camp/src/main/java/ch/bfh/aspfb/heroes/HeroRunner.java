package ch.bfh.aspfb.heroes;

import ch.bfh.aspfb.heroes.service.HeroService;
import ch.bfh.aspfb.heroes.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class HeroRunner implements ApplicationRunner {

    private final HeroService heroService;
    private final PartyService partyService;

    @Autowired
    public HeroRunner(HeroService heroService, PartyService partyService) {
        this.heroService = heroService;
        this.partyService = partyService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("lol generics");
        partyService.createParty("döner");
        partyService.createParty("bier");
        System.out.println("There are " + heroService.getStrongHeroCount() + " with more than 50 atk");
    }
}
