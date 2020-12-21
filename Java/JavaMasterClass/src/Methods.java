public class Methods {


        public static void main(String[] args) {
            boolean gameOver = true;
            int score = 800;
            int levelCompleted = 5;
            int bonus = 100;

//            calculateScore(gameOver, score, levelCompleted, bonus);
//
            score = 10000;
            levelCompleted = 8;
            bonus = 200;

            int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
            System.out.println(calculateHighScorePosition(highScore));
//            System.out.println("Your final score was " + highScore);
//
//
//
//
//
//
//
//
//            calculateScore(gameOver, score, levelCompleted, bonus);


        }

        public String displayHighScorePosition (String name, int position) {
            System.out.println(name  + " Managed to get into position " + position + " on the high score table.");
            return name  + " Managed to get into position " + position + " on the high score table.";
        }

        public static int calculateHighScorePosition (int score) {
            if(score > 1000){
                return 1;
            } else if (score > 500 && score < 1000){
                return 2;
            } else if (score > 100 && score < 500){
                return 2;
            }
            return 4;

        }


        public static int calculateScore(boolean gameOver,int score, int levelCompleted, int bonus) {

            if(gameOver) {
                int finalScore = score + (levelCompleted * bonus);
                finalScore += 2000;
                System.out.println("Your final score was " + finalScore);
                return finalScore;
            }

            return -1;

        }

    }

