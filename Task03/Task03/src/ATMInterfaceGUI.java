import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class ATMInterfaceGUI extends JFrame implements ActionListener {

    // User data (hardcoded for academic purpose)
    private String userId = "Sri123";
    private String pin = "1234";
    private double balance = 10000;

    // Transaction history
    private ArrayList<String> transactions = new ArrayList<>();

    // Login components
    private JTextField userField;
    private JPasswordField pinField;
    private JButton loginButton;

    // ATM menu components
    private JButton historyBtn, withdrawBtn, depositBtn, transferBtn, quitBtn;

    // Constructor
    public ATMInterfaceGUI() {
        setTitle("ATM Interface");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        showLoginScreen();
        setVisible(true);
    }

    // ---------------- LOGIN SCREEN ----------------
    private void showLoginScreen() {
        getContentPane().removeAll();
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("User ID:"));
        userField = new JTextField();
        add(userField);

        add(new JLabel("PIN:"));
        pinField = new JPasswordField();
        add(pinField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        add(new JLabel());
        add(loginButton);

        revalidate();
        repaint();
    }

    // ---------------- ATM MENU ----------------
    private void showATMMenu() {
        getContentPane().removeAll();
        setLayout(new GridLayout(5, 1, 10, 10));

        historyBtn = new JButton("Transaction History");
        withdrawBtn = new JButton("Withdraw");
        depositBtn = new JButton("Deposit");
        transferBtn = new JButton("Transfer");
        quitBtn = new JButton("Quit");

        historyBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        depositBtn.addActionListener(this);
        transferBtn.addActionListener(this);
        quitBtn.addActionListener(this);

        add(historyBtn);
        add(withdrawBtn);
        add(depositBtn);
        add(transferBtn);
        add(quitBtn);

        revalidate();
        repaint();
    }

    // ---------------- BUTTON ACTIONS ----------------
    @Override
    public void actionPerformed(ActionEvent e) {

        // Login
        if (e.getSource() == loginButton) {
            String uid = userField.getText();
            String enteredPin = new String(pinField.getPassword());

            if (uid.equals(userId) && enteredPin.equals(pin)) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                showATMMenu();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid User ID or PIN");
            }
        }

        // Transaction History
        if (e.getSource() == historyBtn) {
            if (transactions.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No transactions yet");
            } else {
                StringBuilder history = new StringBuilder();
                for (String t : transactions) {
                    history.append(t).append("\n");
                }
                JOptionPane.showMessageDialog(this, history.toString(), 
                        "Transaction History", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        // Withdraw
        if (e.getSource() == withdrawBtn) {
            String input = JOptionPane.showInputDialog(this, "Enter amount to withdraw:");
            if (input != null) {
                double amount = Double.parseDouble(input);
                if (amount <= balance) {
                    balance -= amount;
                    transactions.add("Withdrawn: ₹" + amount);
                    JOptionPane.showMessageDialog(this, "Withdrawal Successful\nBalance: ₹" + balance);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient Balance");
                }
            }
        }

        // Deposit
        if (e.getSource() == depositBtn) {
            String input = JOptionPane.showInputDialog(this, "Enter amount to deposit:");
            if (input != null) {
                double amount = Double.parseDouble(input);
                balance += amount;
                transactions.add("Deposited: ₹" + amount);
                JOptionPane.showMessageDialog(this, "Deposit Successful\nBalance: ₹" + balance);
            }
        }

        // Transfer
        if (e.getSource() == transferBtn) {
            String receiver = JOptionPane.showInputDialog(this, "Enter Receiver ID:");
            String amt = JOptionPane.showInputDialog(this, "Enter amount to transfer:");

            if (receiver != null && amt != null) {
                double amount = Double.parseDouble(amt);
                if (amount <= balance) {
                    balance -= amount;
                    transactions.add("Transferred ₹" + amount + " to " + receiver);
                    JOptionPane.showMessageDialog(this, "Transfer Successful\nBalance: ₹" + balance);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient Balance");
                }
            }
        }

        // Quit
        if (e.getSource() == quitBtn) {
            JOptionPane.showMessageDialog(this, "Thank you for using ATM");
            System.exit(0);
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {
        new ATMInterfaceGUI();
    }
}
