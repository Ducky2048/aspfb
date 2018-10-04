package ch.bfh.aspfb.entities;

import java.util.List;

public class Party {
    private List<? extends Hero> heroList;
    private String name;

    public Party(List<? extends Hero> heroList, String name) {
        this.heroList = heroList;
        this.name = name;
    }

    public List<? extends Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(List<? extends Hero> heroList) {
        this.heroList = heroList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
