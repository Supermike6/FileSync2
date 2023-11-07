import javax.swing.*;

public class YourMainClass {
    static String s = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    public static void main(String[] args) {
        try {
            // Set the Look and Feel
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create and display your Swing GUI
        JFrame frame = new JFrame(s);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Click Me");
        frame.getContentPane().add(button);

        frame.pack();
        frame.setVisible(true);
    }
}
