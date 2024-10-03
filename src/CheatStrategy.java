import java.util.Random;

public class CheatStrategy implements Strategy {
    private String playerMove;
    private Random random=new Random();

    public CheatStrategy(String playerMove) {
        this.playerMove=playerMove;
    }

    @Override
    public String determineMove() {
        // Cheat 10% of the time
        if (random.nextInt(10) == 0) {
            return getWinningMove(playerMove);
        } else {
            return new RandomStrategy().determineMove();
        }
    }

    private String getWinningMove(String move) {
        switch (move) {
            case "Rock":
                return "Paper";
            case "Paper":
                return "Scissors";
            case "Scissors":
                return "Rock";
            default:
                return "Rock"; // Default to Rock
        }
    }
}
