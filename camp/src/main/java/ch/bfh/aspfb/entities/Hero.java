package ch.bfh.aspfb.entities;

public class Hero {
    private String name;
    private int health;
    private int armour;
    private int attack;

    public Hero(String name, int health, int armour, int attack) {
        this.name = name;
        this.health = health;
        this.armour = armour;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
