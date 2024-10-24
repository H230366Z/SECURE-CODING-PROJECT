package secureloginsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login extends JDialog {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private List<User> users;

    public Login(Signup parent, List<User> users) {
        super(parent);
        this.users = users;
        setTitle("Login");
        setSize(300, 200); // Window size
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Panel setup with red background
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for better control
        panel.setBackground(Color.RED); // Set the background color to red
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill the space horizontally

        // Initialize components with labels above text fields
        gbc.gridx = 0; gbc.gridy = 0; // First row for username
        panel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1; // Second column for the text field
        txtUsername = new JTextField(); // Default small text field
        panel.add(txtUsername, gbc);

        gbc.gridx = 0; gbc.gridy = 1; // Next row for password
        panel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1; // Second column for the text field
        txtPassword = new JPasswordField(); // Default small password field
        panel.add(txtPassword, gbc);

        // Buttons in a new row
        gbc.gridx = 0; gbc.gridy = 2; // New row for login button
        btnLogin = new JButton("Login"); // Default small button
        btnLogin.setBackground(Color.LIGHT_GRAY); // Set button color to light gray
        panel.add(btnLogin, gbc);

        gbc.gridx = 1; // Next column for cancel button
        btnCancel = new JButton("Cancel"); // Default small button
        btnCancel.setBackground(Color.LIGHT_GRAY); // Set button color to light gray
        panel.add(btnCancel, gbc);

        // Button action for login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText().trim();
                String password = new String(txtPassword.getPassword()).trim();
                if (login(username, password)) {
                    dispose();
                } else {
                    // Simple message box layout for invalid login
                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Button action for cancel
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });

        setVisible(true);
    }

    private boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                new Welcome(user.getName(), user.getRegNumber());
                return true;
            }
        }
        return false; // User not found
    }

    public static void main(String[] args) {
        // For testing purposes
        SwingUtilities.invokeLater(() -> {
            new Login(null, List.of(new User("test", "testUser", "12345", "password")));
        });
    }
}
