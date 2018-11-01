package ch.bfh.aspfb;

import ch.bfh.aspfb.service.HeroService;
import ch.bfh.aspfb.service.PartyService;
import ch.bfh.aspfb.services.impl.HeroServiceImpl;
import ch.bfh.aspfb.services.impl.PartyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

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

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
        bean.setDatabase(Database.H2);
        bean.setGenerateDdl(true);
        return bean;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory (
            DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean bean =
                new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setJpaVendorAdapter(jpaVendorAdapter);
        bean.setPackagesToScan("ch.bfh.aspfb.model");
        return bean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
