import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    private JButton rockButton, paperButton, scissorsButton, quitButton;
    private JTextField playerWinsField, computerWinsField, tiesField;
    private JTextArea resultsTextArea;
    private int playerWins = 0, computerWins = 0, ties = 0;
    private String[] options = {"Rock", "Paper", "Scissors"};
    private Random random = new Random();
    private String lastResult = "";

    public RockPaperScissorsFrame() {
        setTitle("Rock Paper Scissors Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Choose your move"));
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        quitButton = new JButton("Quit");

        rockButton.addActionListener(new GameButtonListener("Rock"));
        paperButton.addActionListener(new GameButtonListener("Paper"));
        scissorsButton.addActionListener(new GameButtonListener("Scissors"));
        quitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);
        buttonPanel.add(quitButton);
        add(buttonPanel, BorderLayout.NORTH);

        // Stats panel
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new GridLayout(3, 2));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Game Stats"));

        statsPanel.add(new JLabel("Player Wins:"));
        playerWinsField = new JTextField("0", 5);
        playerWinsField.setEditable(false);
        statsPanel.add(playerWinsField);

        statsPanel.add(new JLabel("Computer Wins:"));
        computerWinsField = new JTextField("0", 5);
        computerWinsField.setEditable(false);
        statsPanel.add(computerWinsField);

        statsPanel.add(new JLabel("Ties:"));
        tiesField = new JTextField("0", 5);
        tiesField.setEditable(false);
        statsPanel.add(tiesField);

        add(statsPanel, BorderLayout.CENTER);

        // Text area to display results
        resultsTextArea = new JTextArea(10, 40);
        resultsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsTextArea);
        add(scrollPane, BorderLayout.SOUTH);
    }

    // Listener for game buttons
    private class GameButtonListener implements ActionListener {
        private String playerChoice;

        public GameButtonListener(String choice) {
            this.playerChoice = choice;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String computerChoice = options[random.nextInt(3)];
            String result = determineWinner(playerChoice, computerChoice);
            resultsTextArea.append("Player: " + playerChoice + " | Computer: " + computerChoice + " => " + result + "\n");
            updateStats();
        }

        private String determineWinner(String player, String computer) {
            if (player.equals(computer)) {
                ties++;
                lastResult = "It's a tie!";
                return lastResult;
            }

            switch (player) {
                case "Rock":
                    if (computer.equals("Scissors")) {
                        playerWins++;
                        lastResult = "Rock breaks Scissors! Player wins!";
                    } else {
                        computerWins++;
                        lastResult = "Paper covers Rock! Computer wins!";
                    }
                    break;
                case "Paper":
                    if (computer.equals("Rock")) {
                        playerWins++;
                        lastResult = "Paper covers Rock! Player wins!";
                    } else {
                        computerWins++;
                        lastResult = "Scissors cuts Paper! Computer wins!";
                    }
                    break;
                case "Scissors":
                    if (computer.equals("Paper")) {
                        playerWins++;
                        lastResult = "Scissors cuts Paper! Player wins!";
                    } else {
                        computerWins++;
                        lastResult = "Rock breaks Scissors! Computer wins!";
                    }
                    break;
            }
            return lastResult;
        }

        private void updateStats() {
            playerWinsField.setText(String.valueOf(playerWins));
            computerWinsField.setText(String.valueOf(computerWins));
            tiesField.setText(String.valueOf(ties));
        }
    }
}
