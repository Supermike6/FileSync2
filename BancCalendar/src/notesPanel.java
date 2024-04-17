import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;

public class notesPanel extends JFrame
{
    JTextPane textPane;
    public notesPanel()
    {
        setTitle("Jounral App Launcher");
        setSize(350, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        textPane = new JTextPane();
        KeyStroke cmdBackspace = KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
        textPane.getInputMap().put(cmdBackspace, "delete-line");
        textPane.getActionMap().put("delete-line", new AbstractAction() {
            

            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCurrentLine(textPane);
            }

            private static void deleteCurrentLine(JTextPane textPane){
                // Get current caret position
                int caretPosition = textPane.getCaretPosition();
                // Get the line number at caret position
                Element root = textPane.getDocument().getDefaultRootElement();
                int line = root.getElementIndex(caretPosition);

                System.out.println("Caret Position: " + caretPosition);
                System.out.println("Line: " + line);
            
                int index1 = textPane.getCaretPosition();

                
                try {
                    System.out.println(textPane.getDocument().getText(index1, index1+1));
                    textPane.getDocument().remove(index1,0);
                } catch (BadLocationException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            }
            
            
        });

        
        textPane.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Text Inserted");
                System.out.println("Character Count: " + textPane.getText().length());

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("Text Removed");
                System.out.println("Character Count: " + textPane.getText().length());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("Text Changed");
                System.out.println("Character Count: " + textPane.getText().length());
            }
        });
        JScrollPane scrollPane = new JScrollPane(textPane);
        add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);

    }
    public static void main(String[] args) {
        // Create and show the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new notesPanel();
            }
        });
    }


}
