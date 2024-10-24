package secureloginsystem;

import javax.swing.*;
import java.awt.*;

public class Welcome extends JFrame {
    public Welcome(String name, String regNumber) {
        setTitle("Welcome");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set layout and create components
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for better control
        panel.setBackground(Color.RED); // Set background color to red

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill the space horizontally

        // Welcome message label
        gbc.gridx = 0; gbc.gridy = 0; // First row
        JLabel welcomeLabel = new JLabel("Name: " + name + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(welcomeLabel, gbc);

        // Registration number label
        gbc.gridx = 0; gbc.gridy = 1; // Second row
        JLabel regNumberLabel = new JLabel("Your Registration Number is " + regNumber, SwingConstants.CENTER);
        regNumberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(regNumberLabel, gbc);

        // Logout button
        gbc.gridx = 0; gbc.gridy = 2; // Third row
        JButton btnLogout = new JButton("Exit Application");
        btnLogout.addActionListener(e -> {
            dispose(); // Close the welcome page
        });
        panel.add(btnLogout, gbc);

        add(panel);
        setVisible(true); // Show the welcome page
    }
}