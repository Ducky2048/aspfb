package ch.bfh.aspfb.camp.config;

import ch.bfh.aspfb.camp.model.Hero;
import ch.bfh.aspfb.camp.model.Party;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryRestConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Party.class);
        config.exposeIdsFor(Hero.class);
    }
}
