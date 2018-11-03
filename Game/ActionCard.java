package Game;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class ActionCard extends Card {

    public BiConsumer<GameState, Player> play;
    public int buys;
    public int actions;
    public int value;
    public int draws;
    public boolean reaction;


    public ActionCard(String name, int cost, BiConsumer<GameState, Player> play){

            this.name = name;
            this.cost = cost;
            this.play = play;
    }

    public void play(GameState game, Player player){
        play.accept(game, player);
    }

    public static void main (String[] args){

        // TODO How does this work?
        ActionFunctions manyfuncs = new ActionFunctions();
        String[] playernames = {"Toby", "Grace"};
        ActionCard test = new ActionCard("test", 3, (game, player) -> ActionFunctions.playCellar(game, player));

    }
}

