package secureloginsystem;

public class User {
    private String name;
    private String username;
    private String regNumber;
    private String password;

    public User(String name, String username, String regNumber, String password) {
        this.name = name;
        this.username = username;
        this.regNumber = regNumber;
        this.password = password;
    }

    // Getters for user details
    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getRegNumber() { return regNumber; }
    public String getPassword() { return password; }
}