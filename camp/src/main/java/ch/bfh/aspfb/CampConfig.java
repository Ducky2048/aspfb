package ch.bfh.aspfb;

import ch.bfh.aspfb.service.HeroService;
import ch.bfh.aspfb.service.PartyService;
import ch.bfh.aspfb.services.impl.HeroServiceImpl;
import ch.bfh.aspfb.services.impl.PartyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ch.bfh.aspfb.repository")
public class CampConfig {
    @Bean
    public PartyService getPartyServiceBean() {
        return new PartyServiceImpl();
    }

    @Bean
    public HeroService getHeroServiceBean() {
        return new HeroServiceImpl();
    }


}
