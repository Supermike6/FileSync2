package Chopsticks;

import java.util.Scanner;

public class ChopsticksGame {
    private static final int MAX_DEPTH = 4; // Maximum depth for Minimax search
    private static final int PLAYER_HUMAN = 1;
    private static final int PLAYER_AI = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChopsticksGameState currentState = new ChopsticksGameState(new int[]{1, 1}, new int[]{1, 1});
        
        System.out.println("Welcome to Chopsticks!");
        System.out.println("You are player 1. Player 2 is the AI.");

        while (!isTerminalState(currentState)) {
            // Print current game state
            System.out.println("\nCurrent state:");
            System.out.println(currentState);

            // Human player makes a move
            Move humanMove = getHumanMove(scanner, currentState);
            currentState = currentState.applyMove(humanMove);
            if (isTerminalState(currentState)) {
                break;
            }

            // AI suggests a move
            Move aiMove = ChopsticksAI.findBestMove(currentState, MAX_DEPTH);
            System.out.println("\nAI suggests move: " + aiMove);
            currentState = currentState.applyMove(aiMove);
        }

        // Print final game result
        System.out.println("\nFinal state:");
        System.out.println(currentState);
        System.out.println("Game over!");
    }

    private static Move getHumanMove(Scanner scanner, ChopsticksGameState currentState) {
        while (true) {
            System.out.println("\nYour move (format: fromPlayer fromHand toPlayer toHand): ");
            int fromPlayer = scanner.nextInt();
            int fromHand = scanner.nextInt();
            int toPlayer = scanner.nextInt();
            int toHand = scanner.nextInt();

            Move move = new Move(fromPlayer, fromHand, toPlayer, toHand);
            if (currentState.isValidMove(move)) {
                return move;
            } else {
                System.out.println("Invalid move! Please try again.");
            }
        }
    }

    

    private static boolean isTerminalState(ChopsticksGameState state) {
        int[] player1Hands = state.getPlayer1Hands();
        int[] player2Hands = state.getPlayer2Hands();
        return (player1Hands[0] == 0 && player1Hands[1] == 0) || (player2Hands[0] == 0 && player2Hands[1] == 0);
    }
}
