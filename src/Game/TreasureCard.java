package Game;

public class TreasureCard extends Card {

        protected int value;

        public TreasureCard(String name, int cost, int value){

                this.name = name;
                this.cost = cost;
                this.value = value;

        }

        public int getValue(){
                return value;
        }

}

