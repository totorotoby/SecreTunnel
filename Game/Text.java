package Game;
import java.util.ArrayList;
import java.util.Scanner;

public final class Text {

    private static Scanner cardInput = new Scanner(System.in);

    public static String discardText(Player player){

            String cardName;
            player.showHand();
            System.out.println("Which card would you like to discard from your hand?\nHit Return if you would not do not want to discard any.");
            cardName = cardInput.nextLine();

            return cardName;
    }

    public static String trashText(Player player){

        String cardName;
        player.showHand();
        System.out.println("Which card would you like to trash from your hand?\nHit Return if you would not do not want to discard any.");
        cardName = cardInput.nextLine();

        return cardName;
    }

    public static int harbingerText(Player player){

        int index = -1;
        boolean valid = false;
        player.showDiscard();
        System.out.println("Which card from you discard would you like to put on the top of your deck (Enter the corresponding number)?\nHit Return if you would not do not want to discard any.\n");
        while (!valid) {
            try {
                index = cardInput.nextInt();
                valid = true;
            } catch (Exception InputMismatchException) {
                System.out.println("Please enter an integer!");
            }
        }
        return index;

    }

    public static String workshopText(ArrayList<String> toPrint){

        while (toPrint.iterator().hasNext()){
            System.out.println(toPrint.iterator().next() + "\n");
        }
        System.out.println("Which card would you like to Gain?");
        String cardName = cardInput.nextLine();
        return cardName;
    }

    public static ArrayList<Integer> bureaucratText(ArrayList<Player> oPlayers){

        ArrayList<Integer> indices = new ArrayList<Integer>();

        for (Player oPlayer : oPlayers){
            int vc = 0;
            int cardCount = 0;
            for (Card card : oPlayer.hand){
                if (card.getClass() == VictoryCard.class){
                    System.out.println(oPlayer.name + " has a " + card.name);
                    indices.add(cardCount);
                    break;
                }
                else{vc++;}
                cardCount++;
            }
            if (vc == oPlayer.hand.size()){
                System.out.println(oPlayer.name + " does not have any Victory Cards in their hand");
                indices.add(-1);
            }
        }
        return indices;
    }

    public static void moneylenderText(boolean ck){

        if(ck){System.out.println("You trashed a copper and had +3 value this turn");}
        else{System.out.println("You didn't have a copper.");}


    }

    public static void poacherText(int disCount, Player player){

        while(disCount > 0){
            player.discardCard(discardText(player));
        }
    }

    public static String remodelText(ArrayList<ActionCard> canBuy){

        for (int i = 0 ; i < canBuy.size() ; i++) { System.out.println(canBuy.get(i).name); }

        System.out.println("Which card Would you like to Gain?");
        String name = cardInput.nextLine();

        return name;
    }

    public static void main(String[] args){

    }
}