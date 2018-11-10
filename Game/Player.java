package Game;
import java.util.*;

public class Player {

    protected CardStack hand;
    protected CardStack discard;
    protected CardStack deck;
    public int points;
    public String name;

    public Player(String name){

            int i;
            points = 0;
            this.name = name;

            deck = new CardStack();
            discard = new CardStack();
            hand = new CardStack();

            for (i = 0 ; i < 7 ; i++) {
                Card toadd = new TreasureCard("Copper", 0, 1);
                this.deck.add(toadd);
            }
            for (i = 0 ; i < 3 ; i++){
                    this.deck.add(new VictoryCard("Estate", 2, 1));
            }
            //TODO needs to be shuffled                                                                                                                                     

    }

    public boolean deckisEmpty(){
            return this.deck.isEmpty();
    }
    public boolean discardisEmpty(){
            return this.discard.isEmpty();
    }
    public boolean handisEmpty(){
            return this.hand.isEmpty();
    }


    public void showHand(){

            int i;
            for (i = 0 ; i < hand.size() ; i ++){
                    System.out.println(i + ". " + hand.get(i).getName() + "   (" + hand.get(i).getClass().toString() + ")");
            }
    }

    public void showDiscard(){

        int i;
        for (i = 0 ; i < discard.size() ; i ++){
            System.out.println(i + ". " + discard.get(i).getName());
        }
    }

    public void redrawDeck(){

            //TODO add shuffle of discard                                                                                                                                   
            while (!discardisEmpty()){
                    deck.push(discard.pollLast());
            }
    }
    
    public void drawCard(){

        if(deckisEmpty()){
                redrawDeck();
        }
        hand.push(deck.pollLast());
    }

    public ArrayList<Card> taketopCard(int num){

        if(deckisEmpty()){
            redrawDeck();
        }

        ArrayList<Card> cards = new ArrayList<>();

        for (int i = 0 ; i < num ; i++) {
            Card card = deck.pollLast();
            cards.add(card);
        }

        return cards;
    }


    public void drawHand(){

            int i;

            for (i=0 ; i < 5 ; i++){
                    if(deckisEmpty()){
                            redrawDeck();
                    }
                    hand.push(deck.pollLast());
            }
    }

    public void discardCard(String name){
            int discardIndex = hand.indexOf(name);
            discard.push(hand.remove(discardIndex));
    }

    public void discardCard(Card card){ discard.push(card); }

    public void discardDeck(){
            while (!handisEmpty()){
                    discard.push(hand.remove());
            }
    }

    public void gaintopDeck(Card toGain){
            deck.addLast(toGain);
    }

    public void gainDiscard(Card toGain){
            discard.addLast(toGain);
    }

    public void trashCard(String name, LinkedList<Card> trash){ trash.push(hand.remove(hand.indexOf(name))); }

    public void trashCard(Card card, LinkedList<Card> trash){ trash.push(card); }


    public boolean equals(Player toCompare){
        if (toCompare.name.equals(this.name)){return true;}
        return false;
    }

}
