import javax.swing.*;

public class OnlineReservationSystem {

    // ---------- LOGIN FRAME ----------
    JFrame loginFrame;
    JTextField userText;
    JPasswordField passText;

    // ---------- SAMPLE DATA ----------
    String reservedName = "";
    String reservedTrain = "";
    boolean isReserved = false;

    // ---------- CONSTRUCTOR ----------
    OnlineReservationSystem() {
        loginFrame = new JFrame("Online Reservation System - Login");
        loginFrame.setSize(400, 300);
        loginFrame.setLayout(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("User ID:");
        userLabel.setBounds(50, 60, 100, 25);
        loginFrame.add(userLabel);

        userText = new JTextField();
        userText.setBounds(150, 60, 150, 25);
        loginFrame.add(userText);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 100, 25);
        loginFrame.add(passLabel);

        passText = new JPasswordField();
        passText.setBounds(150, 100, 150, 25);
        loginFrame.add(passText);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(150, 150, 80, 30);
        loginFrame.add(loginBtn);

        loginBtn.addActionListener(e -> loginAction());

        loginFrame.setVisible(true);
    }

    // ---------- LOGIN ACTION ----------
    void loginAction() {
        String user = userText.getText();
        String pass = new String(passText.getPassword());

        if (user.equals("admin") && pass.equals("1234")) {
            loginFrame.dispose();
            showMenu();
        } else {
            JOptionPane.showMessageDialog(loginFrame, "Invalid Login");
        }
    }

    // ---------- MAIN MENU ----------
    void showMenu() {
        JFrame menuFrame = new JFrame("Main Menu");
        menuFrame.setSize(400, 300);
        menuFrame.setLayout(null);

        JButton reserveBtn = new JButton("Reserve Ticket");
        reserveBtn.setBounds(100, 50, 200, 30);
        menuFrame.add(reserveBtn);

        JButton cancelBtn = new JButton("Cancel Ticket");
        cancelBtn.setBounds(100, 100, 200, 30);
        menuFrame.add(cancelBtn);

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(100, 150, 200, 30);
        menuFrame.add(logoutBtn);

        reserveBtn.addActionListener(e -> showReservation());
        cancelBtn.addActionListener(e -> showCancel());
        logoutBtn.addActionListener(e -> {
            menuFrame.dispose();
            new OnlineReservationSystem();
        });

        menuFrame.setVisible(true);
    }

    // ---------- RESERVATION FORM ----------
    void showReservation() {
        JFrame rFrame = new JFrame("Ticket Reservation");
        rFrame.setSize(400, 300);
        rFrame.setLayout(null);

        JLabel nameLabel = new JLabel("Passenger Name:");
        nameLabel.setBounds(40, 50, 120, 25);
        rFrame.add(nameLabel);

        JTextField nameText = new JTextField();
        nameText.setBounds(180, 50, 150, 25);
        rFrame.add(nameText);

        JLabel trainLabel = new JLabel("Train Number:");
        trainLabel.setBounds(40, 90, 120, 25);
        rFrame.add(trainLabel);

        JTextField trainText = new JTextField();
        trainText.setBounds(180, 90, 150, 25);
        rFrame.add(trainText);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setBounds(140, 150, 100, 30);
        rFrame.add(submitBtn);

        submitBtn.addActionListener(e -> {
            reservedName = nameText.getText();
            reservedTrain = trainText.getText();
            isReserved = true;

            JOptionPane.showMessageDialog(rFrame,
                    "Reservation Successful!\nName: " + reservedName +
                            "\nTrain No: " + reservedTrain);
        });

        rFrame.setVisible(true);
    }

    // ---------- CANCEL RESERVATION ----------
    void showCancel() {
        JFrame cFrame = new JFrame("Cancel Ticket");
        cFrame.setSize(400, 250);
        cFrame.setLayout(null);

        JButton cancelBtn = new JButton("Cancel Reservation");
        cancelBtn.setBounds(110, 100, 180, 30);
        cFrame.add(cancelBtn);

        cancelBtn.addActionListener(e -> {
            if (isReserved) {
                isReserved = false;
                JOptionPane.showMessageDialog(cFrame, "Ticket Cancelled Successfully");
            } else {
                JOptionPane.showMessageDialog(cFrame, "No Reservation Found");
            }
        });

        cFrame.setVisible(true);
    }

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {
        new OnlineReservationSystem();
    }
}
