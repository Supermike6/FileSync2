package Chopsticks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChopsticksUI extends JFrame {
    private static final int MAX_DEPTH = 4; // Maximum depth for Minimax search
    private static final int PLAYER_HUMAN = 1;
    private static final int PLAYER_AI = 2;

    private ChopsticksGameState currentState;
    private JLabel player1Label;
    private JLabel player2Label;
    private JTextArea messageArea;
    private JTextField moveInputField;
    private JTextArea moveLogArea;
    private List<String> moveLog;

    public ChopsticksUI() {
        super("Chopsticks Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel gamePanel = new JPanel(new GridLayout(4, 1));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        player1Label = new JLabel("Player 1: 1 | 1");
        player2Label = new JLabel("Player 2: 1 | 1");
        messageArea = new JTextArea(5, 20);
        messageArea.setEditable(false);
        moveInputField = new JTextField(20);
        moveLogArea = new JTextArea(10, 40);
        moveLogArea.setEditable(false);
        JScrollPane moveLogScrollPane = new JScrollPane(moveLogArea);

        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame();
            }
        });

        gamePanel.add(player1Label);
        gamePanel.add(player2Label);
        gamePanel.add(new JLabel("Enter move (e.g., A1B2):"));
        gamePanel.add(moveInputField);
        gamePanel.add(messageArea);
        buttonPanel.add(playButton);

        mainPanel.add(gamePanel, BorderLayout.CENTER);
        mainPanel.add(moveLogScrollPane, BorderLayout.EAST);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);

        currentState = new ChopsticksGameState(new int[]{1, 1}, new int[]{1, 1});
        moveLog = new ArrayList<>();
    }

    private void playGame() {
        String input = moveInputField.getText().toUpperCase(); // Convert input to uppercase to handle both lower and uppercase letters
        Move move = ChopsticksNotation.stringToMove(input);

        // Validate move
        if (!isValidMove(move)) {
            messageArea.setText("Invalid move!");
            return;
        }

        // Apply move
        currentState = currentState.applyMove(move);

        // Update player labels
        player1Label.setText("Player 1: " + currentState.getPlayer1Hands()[0] + " | " + currentState.getPlayer1Hands()[1]);
        player2Label.setText("Player 2: " + currentState.getPlayer2Hands()[0] + " | " + currentState.getPlayer2Hands()[1]);

        // Add move to log
        moveLog.add(input);
        updateMoveLog();

        // Check for game over
        if (isGameOver()) {
            messageArea.setText("Game over!");
            moveInputField.setEnabled(false);
        }
    }

    private boolean isValidMove(Move move) {
        // Implement move validation logic here
        // For now, accept all moves
        return true;
    }

    private boolean isGameOver() {
        // Implement game over logic here
        // For now, check if any player has a hand with 0 fingers
        int[] player1Hands = currentState.getPlayer1Hands();
        int[] player2Hands = currentState.getPlayer2Hands();
        return (player1Hands[0] == 0 && player1Hands[1] == 0) || (player2Hands[0] == 0 && player2Hands[1] == 0);
    }

    private void updateMoveLog() {
        StringBuilder sb = new StringBuilder();
        for (String move : moveLog) {
            sb.append(move).append("\n");
        }
        moveLogArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChopsticksUI();
            }
        });
    }
}
