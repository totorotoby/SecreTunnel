package Game;
import java.util.ArrayList;
import java.util.LinkedList;

public class GameState {

    ArrayList<Player> players = new ArrayList<>();
    BaseDecks basedecks;
    ActionDecks actiondecks;
    LinkedList<Card> trash;
    Turn turn;

    public GameState(String[] names) {

        int i;

        for (i = 0; i < names.length; i++) {
            players.add(new Player(names[i]));
        }

        basedecks = new BaseDecks();
        actiondecks = new ActionDecks();
        trash = new LinkedList<Card>();
        turn = new Turn(players);


    }

    public ArrayList<Player> getOtherPlayers(Player currentPlayer) {

        ArrayList<Player> others = new ArrayList<>();

        for (Player player : this.players) {

            if (!player.equals(currentPlayer)) {
                others.add(player);
            }
        }

        return others;
    }

    public ArrayList<String> cardsUpTo(int highCost){

        Card[][] baseCards = (Card[][]) basedecks.Decks.values().toArray();
        Card[][] actionCards = (Card[][]) actiondecks.Decks.values().toArray();

        ArrayList<String> names = new ArrayList<>();

        for (Card[] cards : baseCards){

            if (cards.length != 0) {

                int cost = cards[0].cost;

                if (cost <= highCost){
                    names.add(cards[0].name);
                }
            }
        }

        for (Card[] cards : actionCards){

            if (cards.length != 0) {

                int cost = cards[0].cost;

                if (cost <= highCost){
                    names.add(cards[0].name);
                }
            }
        }
        return names;
    }
}

