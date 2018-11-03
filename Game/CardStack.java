package Game;

import java.util.LinkedList;

public class CardStack<Card> extends LinkedList<Card> {

    public CardStack(){
        super();
    }

    //returns the first index of Card corresponding to the card name
    public int indexOf(String name){

        int i;

        for (i = 0 ; i < this.size() ; i++){
            Card card = this.get(i);
            if (card.getName().equals(name)) {
                break;
            }
        }
        return i;
    }

    public Card remove(String name){

        int i;

        for (i = 0 ; i < this.size() ; i++){
            Card card = this.get(i);
            if (card.getName().equals(name)){
                return this.remove(i);
            }
        }
        return null;
    }

    public Card get(String name){

        int i;

        for (i = 0 ; i < this.size() ; i++){
            Card card = this.get(i);
            if (card.getName().equals(name)){
                return card;
            }
        }
        return null;
    }

}
