package Game;

public class Card {

    protected String name;
    protected int cost;

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public boolean isSame(Card other) {
        return this.name.equals(other.name);
    }

}