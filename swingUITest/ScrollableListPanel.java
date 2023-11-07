import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ScrollableListPanel extends JPanel {

    private DefaultListModel<String> listModel;
    private JList<String> list;
    List<String> listOfStrings = List.of("Item 1", "Item 2", "Item 3", "Item 4");

    public ScrollableListPanel(List<String> listOfStrings) {
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        for (String str : listOfStrings) {
            listModel.addElement(str);
        }

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            

            JFrame frame = new JFrame("Scrollable List Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new ScrollableListPanel(listOfStrings));
            frame.pack();
            frame.setVisible(true);
        });
    }
}
