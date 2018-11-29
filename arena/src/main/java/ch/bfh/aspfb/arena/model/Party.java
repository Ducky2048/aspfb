package ch.bfh.aspfb.arena.model;

import java.util.List;

public class Party {
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
