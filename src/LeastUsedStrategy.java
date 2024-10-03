import java.util.Map;

public class LeastUsedStrategy implements Strategy {
    private Map<String, Integer> playerChoices;

    public LeastUsedStrategy(Map<String, Integer> playerChoices) {
        this.playerChoices=playerChoices;
    }

    @Override
    public String determineMove() {
        // Find the least used symbol by the player
        String leastUsed=playerChoices.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .get().getKey();

        // Return the move that beats the least used
        return getWinningMove(leastUsed);
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

