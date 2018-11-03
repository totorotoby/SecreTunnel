package Game;

public class VictoryCard extends Card {

        protected int points;

        public VictoryCard(String name, int cost, int points){

                this.name = name;
                this.cost = cost;
                this.points = points;

        }

        int getPoints(){
                return points;
        }

}
