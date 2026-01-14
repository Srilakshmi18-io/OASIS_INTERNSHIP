<!-- NUMBER GUESSING GAME – EXPLANATION -->

The Number Guessing Game is a Java application that allows a user to guess a randomly generated number within a limited number of attempts. The program provides feedback for each guess by indicating whether the guessed number is higher or lower than the actual number. It also maintains the number of attempts and calculates a score based on the user’s performance.

<!-- Purpose of the Program -->

The main purpose of this program is to demonstrate the use of basic programming concepts such as random number generation, conditional statements, loops, user interaction through a graphical user interface (GUI), and event handling in Java.

<!-- Working of the Program -->

When the program starts, it generates a random number between 1 and 100 using Java’s Random class. This number is hidden from the user. The program then displays a graphical window where the user can enter a number as their guess.

Each time the user enters a guess and clicks the Check button, the program compares the entered number with the randomly generated number.

If the guessed number is greater than the generated number, the program displays the message “Too High”.

If the guessed number is smaller than the generated number, the program displays the message “Too Low”.

If the guessed number matches the generated number, the program displays a success message indicating that the user has won the game.

<!-- Attempts and Score System -->

The program limits the user to a maximum of five attempts. Each time the user makes a guess, the attempt count is increased by one. The score starts at 100 and decreases by 20 points for every incorrect guess. If the user guesses the correct number within the allowed attempts, the final score and total number of attempts are displayed.

If the user fails to guess the number within five attempts, the game ends and the program displays the correct number along with the final score.

<!-- Input Validation -->

The program ensures that only valid numeric input is accepted. If the user enters a non-numeric value, an error message is shown, and the attempt is not counted. This prevents the program from crashing and improves user experience.

<!-- User Interface -->

The graphical user interface is created using Java Swing. The main components used include:

A window (JFrame) to display the game

A text field (JTextField) to enter the guess

Labels (JLabel) to show messages, attempts, and score

A button (JButton) to submit the guess

The game logic is executed when the user clicks the button, which is handled using an event listener.

<!-- Conclusion -->

The Number Guessing Game is a simple yet effective Java GUI application that helps beginners understand how user input, decision making, and event-driven programming work together. It combines core Java concepts with graphical components to create an interactive and user-friendly program.