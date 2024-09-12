public class Player {
    private final String name;
    private int wins = 0;

    public Player(String nm) {
        this.name = nm;
    }

    public String getname() {
        return name;
    }

    public void addPoints() {
        wins++;
    }

    public int getPoints() {
        return wins;
    }
}
