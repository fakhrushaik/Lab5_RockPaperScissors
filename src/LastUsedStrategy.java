import java.util.Random;

public class LastUsedStrategy implements Strategy {
    private String lastMove;

    public LastUsedStrategy(String lastMove) {
        this.lastMove=lastMove;
    }

    @Override
    public String determineMove() {
        if (lastMove == null) {
            return "Rock"; // Default for the first move
        }

        // Return the move that beats the last move
        return getWinningMove(lastMove);
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

