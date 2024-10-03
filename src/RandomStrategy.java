import java.util.Random;

public class RandomStrategy implements Strategy {
    private static final String[] moves={"Rock", "Paper", "Scissors"};
    private Random random=new Random();

    @Override
    public String determineMove() {
        return moves[random.nextInt(moves.length)];
    }
}

