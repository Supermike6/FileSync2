import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.util.Arrays;

public class PasswordExample {
    public static void main(String[] args) {
        // Define the correct password
        char[] correctPassword = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };

        // Show a password input dialog and get the entered password
        JPasswordField passwordField = new JPasswordField();
        int result = JOptionPane.showConfirmDialog(null, passwordField, "Enter the password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            char[] enteredPassword = passwordField.getPassword();
            

            // Check if the entered password is correct
            if (Arrays.equals(enteredPassword, correctPassword)) {
                System.out.println("Password is correct");
            } else {
                System.out.println("Password is incorrect");
            }
        }
    }
}
