import java.util.Map;
import java.util.Random;

public class ComputerPlayer {
    private Strategy strategy;

    public void selectStrategy(Map<String, Integer> playerChoices, String lastMove, String playerMove) {
        Random random = new Random();
        int strategyChoice = random.nextInt(5);

        switch (strategyChoice) {
            case 0: strategy = new LeastUsedStrategy(playerChoices); break;
            case 1: strategy = new MostUsedStrategy(playerChoices); break;
            case 2: strategy = new LastUsedStrategy(lastMove); break;
            case 3: strategy = new RandomStrategy(); break;
            case 4: strategy = new CheatStrategy(playerMove); break;
        }
    }

    public String makeMove() {
        return strategy.determineMove();
    }
}
