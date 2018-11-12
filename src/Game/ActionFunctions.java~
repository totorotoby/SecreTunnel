package Game;
import javax.swing.*;
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


        ArrayList<String> canGain = game.cardsUpTo(4);

        String gainName = Text.workshopartisanText(canGain);

        Card card = game.actiondecks.takeCard(gainName);
        if (card != null) {
            player.gainDiscard(card);
        }
        else {
            card = game.basedecks.takeCard(gainName);
            player.gainDiscard(card);
        }


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

    public static void playThroneRoom(GameState game, Player player){

        String cardName = Text.throneroomText(player);
        ActionCard card = (ActionCard) player.hand.get(cardName);

        card.play(game, player);
        card.play(game, player);

    }

    public static void playBandit(GameState game, Player player){

        player.gainDiscard(game.basedecks.takeCard("Gold"));

        ArrayList<Player> others = game.getOtherPlayers(player);

        for (Player oPlayer : others){

            ArrayList<Card> toptwo = oPlayer.taketopCard(2);
            for (Card card : toptwo){
                int count = 0;
                if (!(card instanceof TreasureCard) && !card.name.equals("Copper")){
                    System.out.println("You have been forced to discard a" + card.name + "from the top of your deck by " + player.name + "'s Bandit\n");
                    oPlayer.discardCard(toptwo.remove(count));
                    count++;
                }

                if (toptwo.size() == 1 ){
                    System.out.println("You have been forced to trash a" + toptwo.get(0).name + "from the top of your deck by " + player.name + "'s Bandit\n");
                    game.trash.add(toptwo.remove(0));
                }

                if (toptwo.size() == 2 ){
                    int index = Text.banditText(toptwo);
                    System.out.println("You have trashed" + toptwo.get(index));
                    game.trash.add(toptwo.remove(index));
                    System.out.println("You discarded " + toptwo.get(0).name);
                    oPlayer.discardCard(toptwo.remove(0));

                }

            }
        }
    }

    public static void playCouncilRoom(GameState game, Player player){

        ArrayList<Player> others = game.getOtherPlayers(player);

        for (Player oPlayer : others){
            oPlayer.drawCard();
        }

    }

    public static void playLibrary(GameState game, Player player){

        while(player.hand.size() < 8){

            Card todraw = player.taketopCard(1).get(0);

            if (todraw instanceof ActionCard){

                String ans = Text.libraryText(todraw);

                if (ans.equals("Yes")){ player.hand.add(todraw); }
                else{ player.discardCard(todraw); }

            }

            else{
                player.hand.add(todraw);
                System.out.println("You added " + todraw.name + " to your hand. \n");
            }
        }
    }


    public static void playMine(GameState game, Player player){

        ArrayList<Card> canDiscard = new ArrayList<>();

        for (Card card : player.hand) {
            if (card instanceof TreasureCard) {
                canDiscard.add(card);
            }
        }

        if (canDiscard.size() > 0) {

            String toDiscard = Text.mineText(canDiscard);

            player.discardCard(player.hand.get(toDiscard));

            if (toDiscard.equals("Copper")) {
                player.hand.add(game.basedecks.takeCard("Silver"));
            }

            if (toDiscard.equals("Silver")) {
                player.hand.add(game.basedecks.takeCard("Gold"));
            }

        }

    }

    public static void playSentry(GameState game, Player player){

        ArrayList<Card> toptwo = player.taketopCard(2);

        int[] choices = Text.sentryText(toptwo);

        int c = 0;

        for (int option : choices){

            if (option == 1){
                player.discardCard(toptwo.remove(c));
            }
            if (option == 2){
                player.trashCard(toptwo.remove(c), game.trash);
            }
            if (option == 3){
                player.deck.addLast(toptwo.remove(c));
            }
            c++;
        }
    }

    public static void playWitch(GameState game, Player player){

        ArrayList<Player> oPlayers = game.getOtherPlayers(player);

        for (Player oPlayer : oPlayers){
            System.out.println(oPlayer.name + " has gained a curse \n");
            oPlayer.gainDiscard(game.basedecks.takeCard("Curse"));
        }
    }

    public static void playArtisan(GameState game, Player player){

        ArrayList<String> names = game.cardsUpTo(5);

        String toGain = Text.workshopartisanText(names);

        Card card = game.actiondecks.takeCard(toGain);

        if (card != null) {
            player.hand.addLast(card);
        }
        else{
            card = game.basedecks.takeCard(toGain);
            player.hand.addLast(card);
        }

        String cardName = Text.artisanText(player);

        player.gaintopDeck(player.hand.get(cardName));

    }

    public static void main(String[] args){


    }

}
