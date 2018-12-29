package ch.bfh.aspfb.promoter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "heroes.promoter.messages")
public class MessageProperties {
    private String arenaFallback;

    public String getArenaFallback() {
        return arenaFallback;
    }

    public void setArenaFallback(String arenaFallback) {
        this.arenaFallback = arenaFallback;
    }
}
