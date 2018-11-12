package Game;
import java.util.ArrayList;

public class Turn {

    Player player;
    ArrayList<Player> players;
    public int money;
    public int actions;
    public int buys;
    private int playerCount;

    public Turn(ArrayList<Player> players){
            this.players = players;
            this.playerCount = 0;
    }

    public void next(){

            playerCount++;

            if (playerCount == players.size()){
                    playerCount = 0;
            }

            player = players.get(playerCount);
            money = 0;
            actions = 1;
            buys = 1;
    }
}
