package ch.bfh.aspfb.camp;

import ch.bfh.aspfb.camp.service.HeroService;
import ch.bfh.aspfb.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CampRunner implements ApplicationRunner {

    private final HeroService heroService;
    private final PartyService partyService;

    @Autowired
    public CampRunner(HeroService heroService, PartyService partyService) {
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
