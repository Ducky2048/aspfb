package ch.bfh.aspfb.archive.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Party {
    @JsonProperty("partyId")
    private String id;

    private String name;
    private List<Hero> members;

    @Override
    public String toString() {
        return "Party{" +
                "name='" + name + '\'' +
                ", members=" + members +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hero> getMembers() {
        return members;
    }

    public void setMembers(List<Hero> members) {
        this.members = members;
    }
}
