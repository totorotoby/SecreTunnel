package Game;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public final class ActionFunctions {

    public static void playCellar(GameState game, Player player){

            int todraw = 0;
            String cardName = "_";

            while (!cardName.isEmpty()){
               cardName = Text.discardText(player);
               player.discardCard(cardName);
               todraw++;
            }
            while (todraw > 0) {
                player.drawCard();
                todraw--;
            }
    }

    public static void playChapel(GameState game, Player player){

        String cardName = "_";
        int trashNum = 0;

        while (!cardName.isEmpty() && trashNum < 5){
            cardName = Text.trashText(player);
            player.trashCard(cardName, game.trash);
            trashNum++;
        }
    }

    public static void playHarbinger(GameState game, Player player){

        int toTop = Text.harbingerText(player);
        player.deck.addLast(player.discard.remove(toTop));

    }

    public static void playVassel(GameState game, Player player){

        if (player.deck.getLast().getClass() == ActionCard.class){
            ActionCard topDeck = (ActionCard) player.deck.getLast();
            topDeck.play(game,player);
            player.discard.push(topDeck);
        }
        else {
            Card topDeck = player.deck.pollLast();
            player.discard.push(topDeck);
        }
    }

    public static void playWorkShop(GameState game, Player player){


        ArrayList<String> canGain = new ArrayList<>();
        HashMap actionDecks = game.actiondecks.Decks;

        String[] possibleGain = (String[]) actionDecks.keySet().toArray();
        for (int i = 0 ; i < possibleGain.length; i++){
            if (game.actiondecks.isEmpty(possibleGain[i]) && game.actiondecks.Decks.get(possibleGain[i]).get(0).cost <= 4){
                    canGain.add(possibleGain[i]);
            }
        }

        String gainName = Text.workshopText(canGain);
        player.gainDiscard(game.actiondecks.takeCard(gainName));

    }

    public static void playBureaucrat(GameState game, Player player){

        ArrayList<Player> oPlayers = new ArrayList<>();

        if (!game.actiondecks.isEmpty("Silver")) {
            player.gaintopDeck(game.actiondecks.takeCard("Silver"));
        }

        for (Player oPlayer : game.players){
            if (!oPlayer.equals(player)){oPlayers.add(oPlayer);}
        }

        ArrayList<Integer> indices = Text.bureaucratText(oPlayers);

        for (int i = 0 ; i < indices.size() ; i++){
            int index = indices.get(i);
            if (index != -1){
                Player topPlayer = oPlayers.get(i);
                topPlayer.deck.addLast(topPlayer.hand.get(index));
            }
        }
    }

    public static void playMoneyLender(GameState game, Player player){

        boolean ck = false;

        for (Card card : player.hand){
            if (card.name.equals("Copper")){ ck = true; }
            if (ck){
                player.trashCard("Copper", game.trash);
                game.turn.money += 3;
                break;
            }
        }
        Text.moneylenderText(ck);
    }


    public static void playPoacher(GameState game, Player player){

        int count = 0;

        for (ArrayList<Card> pile : game.actiondecks.Decks.values()){
            if (pile.isEmpty()){count++;}
        }
        for (ArrayList<Card> pile : game.basedecks.Decks.values()){
            if (pile.isEmpty()){count++;}
        }

        Text.poacherText(count, player);
    }

    public static void playRemodel(GameState game, Player player){

       String cardName = Text.trashText(player);
       int cost = player.hand.get(cardName).cost + 2;
       game.trash.add(player.hand.remove(cardName));

       ArrayList<ActionCard> canBuy = new ArrayList<>();

        ActionCard[] cards = (ActionCard[]) game.actiondecks.Decks.values().toArray();

       for (int i = 0 ; i < cards.length; i++){

           if (cards[i].cost <= cost) {
               canBuy.add(cards[i]);
           }
       }

       String cardtoGain = Text.remodelText(canBuy);
       player.gainDiscard(game.actiondecks.Decks.get(cardtoGain).remove(0));

    }


    

    public static void main(String[] args){


    }

}
