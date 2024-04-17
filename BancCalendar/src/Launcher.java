import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Launcher extends JFrame implements ActionListener {
    private JPanel contentPanel;
    private JPanel clockPanel;
    private JPanel calendarPanel;
    private JPanel todoPanel;
    private JPanel notesPanel;

    public Launcher() {
        setTitle("Productivity App Launcher");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create content panel with border layout
        contentPanel = new JPanel(new BorderLayout());
        setContentPane(contentPanel);

        // Create toggle buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        ImageIcon todoIcon = new ImageIcon("todo.png");
        ImageIcon notesIcon = new ImageIcon("notes.png");

        // Create toggle buttons with icons
        JButton clockButton = new JButton(getScaledImage("Icons/Calendar.png",50,50));
        JButton calendarButton = new JButton(getScaledImage("Icons/Clock.png",50,50));
        JButton todoButton = new JButton(todoIcon);
        JButton notesButton = new JButton(notesIcon);

        // Add action listeners to toggle buttons
        clockButton.addActionListener(this);
        calendarButton.addActionListener(this);
        todoButton.addActionListener(this);
        notesButton.addActionListener(this);

        // Add toggle buttons to the panel
        buttonPanel.add(clockButton);
        buttonPanel.add(calendarButton);
        buttonPanel.add(todoButton);
        buttonPanel.add(notesButton);

        // Add toggle buttons panel to the content panel
        contentPanel.add(buttonPanel, BorderLayout.NORTH);

        // Create feature panels
        clockPanel = new JPanel();
        calendarPanel = new JPanel();
        todoPanel = new JPanel();
        notesPanel = new JPanel();

        // Add feature panels to the content panel
        contentPanel.add(clockPanel, BorderLayout.CENTER);
        contentPanel.add(calendarPanel, BorderLayout.CENTER);
        contentPanel.add(todoPanel, BorderLayout.CENTER);
        contentPanel.add(notesPanel, BorderLayout.CENTER);

        // Initially hide all feature panels except the clockPanel
        clockPanel.setVisible(true);
        calendarPanel.setVisible(false);
        todoPanel.setVisible(false);
        notesPanel.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getActionCommand().equals("Clock")) {
            showClockPanel();
        } else if (e.getActionCommand().equals("Calendar")) {
            showCalendarPanel();
        } else if (e.getActionCommand().equals("To-Do List")) {
            showTodoPanel();
        } else if (e.getActionCommand().equals("Notes")) {
            showNotesPanel();
        }
    }

    private void showClockPanel() {
        clockPanel.setVisible(true);
        calendarPanel.setVisible(false);
        todoPanel.setVisible(false);
        notesPanel.setVisible(false);
    }

    private void showCalendarPanel() {
        clockPanel.setVisible(false);
        calendarPanel.setVisible(true);
        todoPanel.setVisible(false);
        notesPanel.setVisible(false);
    }

    private void showTodoPanel() {
        clockPanel.setVisible(false);
        calendarPanel.setVisible(false);
        todoPanel.setVisible(true);
        notesPanel.setVisible(false);
    }

    private void showNotesPanel() {
        clockPanel.setVisible(false);
        calendarPanel.setVisible(false);
        todoPanel.setVisible(false);
        notesPanel.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Launcher launcher = new Launcher();
            launcher.setVisible(true);
        });
    }

    public ImageIcon getScaledImage(String path, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(path);
        // Create a scaled version of the image
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, 4);
        // Create a new ImageIcon with the scaled image
        return new ImageIcon(scaledImage);
    }
}
