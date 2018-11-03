package Game;
import java.util.ArrayList;
import java.util.LinkedList;

public class GameState {

		ArrayList<Player> players = new ArrayList<>();
        BaseDecks basedecks;
        ActionDecks actiondecks;
        LinkedList<Card> trash;
        Turn turn;

        public GameState(String[] names){

                int i;

                for (i=0 ; i < names.length ; i++){
                        players.add(new Player(names[i]));
                }

                basedecks = new BaseDecks();
                actiondecks = new ActionDecks();
                trash = new LinkedList<Card>();
                turn = new Turn(players);


        }
}

