import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

class Book {
    String name;
    int quantity;

    Book(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}

public class DigitalLibraryManagement extends JFrame {

    ArrayList<Book> books = new ArrayList<>();

    CardLayout card = new CardLayout();
    JPanel mainPanel = new JPanel(card);

    JTextArea displayArea = new JTextArea();

    public DigitalLibraryManagement() {
        setTitle("Digital Library Management System");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        books.add(new Book("Java Programming", 3));
        books.add(new Book("Database Management", 2));
        books.add(new Book("Software Engineering", 4));

        mainPanel.add(loginPanel(), "login");
        mainPanel.add(adminPanel(), "admin");
        mainPanel.add(userPanel(), "user");

        add(mainPanel);
        card.show(mainPanel, "login");
        setVisible(true);
    }

    /* ---------------- LOGIN PANEL ---------------- */

    JPanel loginPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();

        JButton login = new JButton("Login");

        panel.add(new JLabel("Username:"));
        panel.add(user);
        panel.add(new JLabel("Password:"));
        panel.add(pass);
        panel.add(new JLabel());
        panel.add(login);

        login.addActionListener(e -> {
            String u = user.getText();
            String p = new String(pass.getPassword());

            if (u.equals("admin") && p.equals("admin123")) {
                card.show(mainPanel, "admin");
            } else if (u.equals("user") && p.equals("user123")) {
                card.show(mainPanel, "user");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
        });

        return panel;
    }

    /* ---------------- ADMIN PANEL ---------------- */

    JPanel adminPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel buttons = new JPanel(new GridLayout(1, 4));
        JButton addBook = new JButton("Add Book");
        JButton updateBook = new JButton("Update Quantity");
        JButton viewBooks = new JButton("View Books");
        JButton logout = new JButton("Logout");

        buttons.add(addBook);
        buttons.add(updateBook);
        buttons.add(viewBooks);
        buttons.add(logout);

        displayArea.setEditable(false);

        addBook.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Book Name:");
            int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));
            books.add(new Book(name, qty));
            JOptionPane.showMessageDialog(this, "Book Added");
        });

        updateBook.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Book Name:");
            for (Book b : books) {
                if (b.name.equalsIgnoreCase(name)) {
                    b.quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter New Quantity:"));
                    JOptionPane.showMessageDialog(this, "Quantity Updated");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Book Not Found");
        });

        viewBooks.addActionListener(e -> displayBooks());

        logout.addActionListener(e -> card.show(mainPanel, "login"));

        panel.add(buttons, BorderLayout.NORTH);
        panel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        return panel;
    }

    /* ---------------- USER PANEL ---------------- */

    JPanel userPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel buttons = new JPanel(new GridLayout(1, 5));
        JButton view = new JButton("View Books");
        JButton search = new JButton("Search Book");
        JButton issue = new JButton("Issue Book");
        JButton ret = new JButton("Return Book");
        JButton email = new JButton("Email Query");
        JButton logout = new JButton("Logout");

        buttons.add(view);
        buttons.add(search);
        buttons.add(issue);
        buttons.add(ret);
        buttons.add(email);
        buttons.add(logout);

        view.addActionListener(e -> displayBooks());

        search.addActionListener(e -> {
            String key = JOptionPane.showInputDialog("Enter Book Name:");
            displayArea.setText("");
            for (Book b : books) {
                if (b.name.toLowerCase().contains(key.toLowerCase())) {
                    displayArea.append(b.name + " - Available: " + b.quantity + "\n");
                }
            }
        });

        issue.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Book Name:");
            for (Book b : books) {
                if (b.name.equalsIgnoreCase(name) && b.quantity > 0) {
                    b.quantity--;
                    JOptionPane.showMessageDialog(this, "Book Issued");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Book Not Available");
        });

        ret.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Book Name:");
            for (Book b : books) {
                if (b.name.equalsIgnoreCase(name)) {
                    b.quantity++;
                    JOptionPane.showMessageDialog(this, "Book Returned");
                    return;
                }
            }
        });

        email.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Email sent to library@support.com"));

        logout.addActionListener(e -> card.show(mainPanel, "login"));

        panel.add(buttons, BorderLayout.NORTH);
        panel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        return panel;
    }

    void displayBooks() {
        displayArea.setText("");
        for (Book b : books) {
            displayArea.append(b.name + " - Available: " + b.quantity + "\n");
        }
    }

    public static void main(String[] args) {
        new DigitalLibraryManagement();
    }
}
