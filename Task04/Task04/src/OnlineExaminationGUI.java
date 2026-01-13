
import java.awt.*;
import javax.swing.*;

public class OnlineExaminationGUI extends JFrame {

    CardLayout cardLayout;
    JPanel mainPanel;

    String username = "admin";
    String password = "1234";

    int currentQuestion = 0;
    int score = 0;
    int timeLeft = 60;

    Timer timer;

    String[] questions = {
            "Java is a ____ language?",
            "Which keyword is used to inherit a class?",
            "JVM stands for?"
    };

    String[][] options = {
            {"Low level", "High level", "Assembly", "Machine"},
            {"this", "super", "extends", "implements"},
            {"Java Virtual Machine", "Java Variable Machine", "Java Visual Machine", "None"}
    };

    int[] answers = {1, 2, 0};

    JRadioButton[] radioButtons = new JRadioButton[4];
    ButtonGroup bg = new ButtonGroup();
    JLabel questionLabel, timerLabel;

    public OnlineExaminationGUI() {
        setTitle("Online Examination System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(loginPanel(), "login");
        mainPanel.add(menuPanel(), "menu");
        mainPanel.add(examPanel(), "exam");

        add(mainPanel);
        cardLayout.show(mainPanel, "login");
        setVisible(true);
    }

    JPanel loginPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");

        panel.add(new JLabel("Username:"));
        panel.add(userField);
        panel.add(new JLabel("Password:"));
        panel.add(passField);
        panel.add(new JLabel());
        panel.add(loginBtn);

        loginBtn.addActionListener(e -> {
            if (userField.getText().equals(username)
                    && new String(passField.getPassword()).equals(password)) {
                cardLayout.show(mainPanel, "menu");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login");
            }
        });

        return panel;
    }

    JPanel menuPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));

        JButton startExam = new JButton("Start Exam");
        JButton updateProfile = new JButton("Update Profile");
        JButton logout = new JButton("Logout");

        panel.add(startExam);
        panel.add(updateProfile);
        panel.add(logout);

        startExam.addActionListener(e -> {
            currentQuestion = 0;
            score = 0;
            timeLeft = 60;
            startTimer();
            loadQuestion();
            cardLayout.show(mainPanel, "exam");
        });

        updateProfile.addActionListener(e -> {
            username = JOptionPane.showInputDialog("Enter new username:");
            password = JOptionPane.showInputDialog("Enter new password:");
            JOptionPane.showMessageDialog(this, "Profile Updated");
        });

        logout.addActionListener(e -> System.exit(0));

        return panel;
    }

    JPanel examPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        questionLabel = new JLabel();
        timerLabel = new JLabel("Time: 60");

        JPanel top = new JPanel(new BorderLayout());
        top.add(timerLabel, BorderLayout.EAST);
        top.add(questionLabel, BorderLayout.CENTER);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));

        for (int i = 0; i < 4; i++) {
            radioButtons[i] = new JRadioButton();
            bg.add(radioButtons[i]);
            optionsPanel.add(radioButtons[i]);
        }

        JButton nextBtn = new JButton("Next");

        nextBtn.addActionListener(e -> nextQuestion());

        panel.add(top, BorderLayout.NORTH);
        panel.add(optionsPanel, BorderLayout.CENTER);
        panel.add(nextBtn, BorderLayout.SOUTH);

        return panel;
    }

    void loadQuestion() {
        bg.clearSelection();
        questionLabel.setText("Q" + (currentQuestion + 1) + ": " + questions[currentQuestion]);

        for (int i = 0; i < 4; i++) {
            radioButtons[i].setText(options[currentQuestion][i]);
        }
    }

    void nextQuestion() {
        for (int i = 0; i < 4; i++) {
            if (radioButtons[i].isSelected() && i == answers[currentQuestion]) {
                score++;
            }
        }

        currentQuestion++;

        if (currentQuestion < questions.length) {
            loadQuestion();
        } else {
            timer.stop();
            JOptionPane.showMessageDialog(this,
                    "Exam Finished\nScore: " + score + "/" + questions.length);
            cardLayout.show(mainPanel, "menu");
        }
    }

    void startTimer() {
        timer = new Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time: " + timeLeft);

            if (timeLeft == 0) {
                timer.stop();
                JOptionPane.showMessageDialog(this,
                        "Time Over!\nScore: " + score + "/" + questions.length);
                cardLayout.show(mainPanel, "menu");
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new OnlineExaminationGUI();
    }
}
