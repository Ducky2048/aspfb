package ch.bfh.aspfb.arena.model;

public class Fight {
    private String id;

    private Party challenger;
    private Party challengee;

    private String winner;

    public Fight(Party challenger, Party challengee) {
        this.challenger = challenger;
        this.challengee = challengee;
    }

    @Override
    public String toString() {
        return "Fight{" +
                "id='" + id + '\'' +
                ", challenger=" + challenger +
                ", challengee=" + challengee +
                ", winner='" + winner + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Party getChallenger() {
        return challenger;
    }

    public void setChallenger(Party challenger) {
        this.challenger = challenger;
    }

    public Party getChallengee() {
        return challengee;
    }

    public void setChallengee(Party challengee) {
        this.challengee = challengee;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}