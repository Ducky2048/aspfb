package ch.bfh.aspfb.arena.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "heroes.arena.messages")
public class MessageConfiguration {
    private String victoryMessage;

    public String getVictoryMessage() {
        return victoryMessage;
    }

    public void setVictoryMessage(String victoryMessage) {
        this.victoryMessage = victoryMessage;
    }
}
