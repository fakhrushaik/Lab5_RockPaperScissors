import java.util.Map;

public class MostUsedStrategy implements Strategy {
    private Map<String, Integer> playerChoices;

    public MostUsedStrategy(Map<String, Integer> playerChoices) {
        this.playerChoices=playerChoices;
    }

    @Override
    public String determineMove() {
        // Find the most used symbol by the player
        String mostUsed=playerChoices.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();

        // Return the move that beats the most used
        return getWinningMove(mostUsed);
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

