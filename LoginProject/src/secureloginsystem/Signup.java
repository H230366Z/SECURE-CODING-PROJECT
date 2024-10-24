package secureloginsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Signup extends JDialog {
    private JTextField txtName;
    private JTextField txtUsername;
    private JTextField txtRegNumber;
    private JPasswordField txtPassword;
    private JButton btnSignUp;
    private JPanel panel;
    private List<User> users;
    private JButton btnLogin;

    public Signup(JFrame parent) {
        super(parent);
        setTitle("Sign Up");
        setSize(400, 300); // Window size
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Remove the icon from the title
        setIconImage(null);

        users = new ArrayList<>();

        // Change the layout to GridBagLayout for better control
        panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Use GridBagLayout for positioning
        panel.setBackground(Color.RED); // Set the background color to red
        setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fill the space horizontally

        // Add labels and text fields
        gbc.gridx = 0; gbc.gridy = 0; // First row for name
        panel.add(new JLabel("StudentName:"), gbc);

        gbc.gridx = 1; // Second column for the text field
        txtName = new JTextField(10); // Width of the text field
        panel.add(txtName, gbc);

        gbc.gridx = 0; gbc.gridy = 1; // Next row for username
        panel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1; // Second column for the text field
        txtUsername = new JTextField(10); // Width of the text field
        panel.add(txtUsername, gbc);

        gbc.gridx = 0; gbc.gridy = 2; // Next row for registration number
        panel.add(new JLabel("RegNumber:"), gbc);

        gbc.gridx = 1; // Second column for the text field
        txtRegNumber = new JTextField(10); // Width of the text field
        panel.add(txtRegNumber, gbc);

        gbc.gridx = 0; gbc.gridy = 3; // Next row for password
        panel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1; // Second column for the text field
        txtPassword = new JPasswordField(10); // Width of the text field
        panel.add(txtPassword, gbc);

        // Set button size and use lowercase text
        gbc.gridx = 0; gbc.gridy = 4; // New row for sign-up button
        btnSignUp = new JButton("SignUp");
        btnSignUp.setPreferredSize(new Dimension(80, 30)); // Reduced size
        btnSignUp.setBackground(Color.LIGHT_GRAY); // Set button color to light gray
        panel.add(btnSignUp, gbc);

        gbc.gridx = 1; // Next column for the login button
        btnLogin = new JButton("Login");
        btnLogin.setPreferredSize(new Dimension(80, 30)); // Reduced size
        btnLogin.setBackground(Color.LIGHT_GRAY); // Set button color to light gray
        panel.add(btnLogin, gbc);

        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText().trim();
                String regNumber = txtRegNumber.getText().trim();
                String username = txtUsername.getText().trim();
                String password = new String(txtPassword.getPassword()).trim();

                if (name.isEmpty() || regNumber.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    addUser(name, username, regNumber, password);
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login(Signup.this, users);
            }
        });

        setVisible(true);
    }

    private void addUser(String name, String username, String regNumber, String password) {
        User newUser = new User(name, username, regNumber, password);
        users.add(newUser);

        JOptionPane.showMessageDialog(null, "User registered successfully!");
        clearInputFields();
    }

    private void clearInputFields() {
        txtName.setText("");
        txtUsername.setText("");
        txtRegNumber.setText("");
        txtPassword.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Signup(null));
    }
}
