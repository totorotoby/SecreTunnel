package Game;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class ActionDecks {

    HashMap<String, ArrayList<Card>> Decks;
    ArrayList<Card> actionRefs = new ArrayList<Card>();

    public ActionDecks(){

    Collections.shuffle(actionRefs);

    }

    public boolean isEmpty(String name){return Decks.get(name).isEmpty();}

    public ActionCard takeCard(String name){

        if (!isEmpty(name)) {
            ArrayList<Card> pile = Decks.get(name);
            if (pile != null) {
                return (ActionCard) pile.remove(pile.size());
            }
            return null;
        }
        return null;
    }

}
