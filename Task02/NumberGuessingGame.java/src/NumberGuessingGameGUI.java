import java.util.Random;
import javax.swing.*;

public class NumberGuessingGameGUI {

    JFrame frame;
    JTextField guessField;
    JLabel messageLabel, attemptsLabel, scoreLabel;

    int numberToGuess;
    int attempts = 0;
    int maxAttempts = 5;
    int score = 100;

    // ---------- CONSTRUCTOR ----------
    NumberGuessingGameGUI() {

        // Generate random number
        Random rand = new Random();
        numberToGuess = rand.nextInt(100) + 1;

        frame = new JFrame("Number Guessing Game");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Guess the Number (1 - 100)");
        titleLabel.setBounds(100, 20, 250, 25);
        frame.add(titleLabel);

        JLabel guessLabel = new JLabel("Your Guess:");
        guessLabel.setBounds(50, 60, 100, 25);
        frame.add(guessLabel);

        guessField = new JTextField();
        guessField.setBounds(150, 60, 150, 25);
        frame.add(guessField);

        JButton guessButton = new JButton("Check");
        guessButton.setBounds(150, 100, 80, 30);
        frame.add(guessButton);

        messageLabel = new JLabel("");
        messageLabel.setBounds(50, 140, 300, 25);
        frame.add(messageLabel);

        attemptsLabel = new JLabel("Attempts: 0 / 5");
        attemptsLabel.setBounds(50, 170, 200, 25);
        frame.add(attemptsLabel);

        scoreLabel = new JLabel("Score: 100");
        scoreLabel.setBounds(50, 200, 200, 25);
        frame.add(scoreLabel);

        guessButton.addActionListener(e -> checkGuess());

        frame.setVisible(true);
    }

    // ---------- GAME LOGIC ----------
    void checkGuess() {
        if (attempts >= maxAttempts) {
            return;
        }

        int userGuess;
        try {
            userGuess = Integer.parseInt(guessField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Enter a valid number!");
            return;
        }

        attempts++;
        attemptsLabel.setText("Attempts: " + attempts + " / " + maxAttempts);

        if (userGuess > numberToGuess) {
            messageLabel.setText("Too High!");
            score -= 20;
        } else if (userGuess < numberToGuess) {
            messageLabel.setText("Too Low!");
            score -= 20;
        } else {
            messageLabel.setText("🎉 Correct! You Win!");
            JOptionPane.showMessageDialog(frame,
                    "You guessed the number!\nAttempts: " + attempts +
                    "\nScore: " + score);
            disableGame();
            return;
        }

        scoreLabel.setText("Score: " + score);

        if (attempts == maxAttempts) {
            JOptionPane.showMessageDialog(frame,
                    "Game Over!\nThe number was: " + numberToGuess +
                    "\nScore: " + score);
            disableGame();
        }
    }

    // ---------- DISABLE INPUT ----------
    void disableGame() {
        guessField.setEnabled(false);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {
        new NumberGuessingGameGUI();
    }
}
