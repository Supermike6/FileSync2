import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.text.*;

public class TextComponentExample {
    public static void main(String[] args) {
        // Create a JFrame to hold our components
        JFrame frame = new JFrame("Text Component Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // JTextField Example
        JTextField textField = new JTextField("Text Field");
        textField.setColumns(15); // Set the width of the text field
        frame.add(textField);

        // JTextArea Example
        JTextArea textArea = new JTextArea("Text Area");
        textArea.setPreferredSize(new Dimension(200, 100)); // Set preferred size
        frame.add(textArea);

        // JTextPane Example
        JTextPane textPane = new JTextPane();
        textPane.setText("Text Pane");
        textPane.setPreferredSize(new Dimension(200, 100)); // Set preferred size
        frame.add(textPane);

        // JTextComponent Example
        JTextComponent textComponent = new JTextPane(); // JTextComponent is an abstract class, we use JTextPane here
        textComponent.setText("Text Component");
        textComponent.setPreferredSize(new Dimension(200, 100)); // Set preferred size
        frame.add(textComponent);

        // JFormattedTextField Example
        JFormattedTextField formattedTextField = new JFormattedTextField(NumberFormat.getInstance());
        formattedTextField.setValue(123); // Set initial value
        formattedTextField.setColumns(10); // Set the width of the formatted text field
        frame.add(formattedTextField);

        // Display the frame
        frame.setVisible(true);
    }
}
