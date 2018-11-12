package Game;
import java.util.*;


public class BaseDecks {

        HashMap<String, ArrayList<Card>> Decks;

        public BaseDecks(){

                Decks.put("Copper", makeDeck("Copper", 0, 1, false, 32));
                Decks.put("Silver", makeDeck("Silver", 3, 2, false, 40));
                Decks.put("Gold", makeDeck("Copper", 6, 3, false, 30));
                Decks.put("Copper", makeDeck("Copper", 0, 1, false, 32));
                Decks.put("Estate", makeDeck("Estate", 2, 1, true, 12));
                Decks.put("Duchy", makeDeck("Duchy", 5, 3, true, 12));
                Decks.put("Province", makeDeck("Province", 8, 6, true, 12));
                Decks.put("Curse", makeDeck("Curse", 0, -1, true, 30));

        }

        public ArrayList<Card> makeDeck(String Name, int cost, int value, boolean typeFlag ,int num){

                int i;
                ArrayList<Card> pile = new ArrayList<Card>();

                for (i=0 ; i < num ; i++){
                        if (typeFlag = true){
                                pile.add(new VictoryCard(Name, cost, value));
                        }
                        else{
                                pile.add(new TreasureCard(Name, cost, value));
                        }
                }
                return pile;
        }

        public boolean isLeft(String name){
                return Decks.get(name).isEmpty();
        }

        public Card takeCard(String name){
                return Decks.get(name).remove(0);
        }

}