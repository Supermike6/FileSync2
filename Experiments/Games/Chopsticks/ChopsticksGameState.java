package Chopsticks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChopsticksGameState {
    private int[] player1Hands;
    private int[] player2Hands;

    public List<Move> generatePossibleMoves() {
        List<Move> possibleMoves = new ArrayList<>();
        for (int fromPlayer = 1; fromPlayer <= 2; fromPlayer++) {
            for (int fromHand = 0; fromHand < 2; fromHand++) {
                for (int toPlayer = 1; toPlayer <= 2; toPlayer++) {
                    if (toPlayer != fromPlayer) {
                        for (int toHand = 0; toHand < 2; toHand++) {
                            if (isValidMove(fromPlayer, fromHand, toPlayer, toHand)) {
                                possibleMoves.add(new Move(fromPlayer, fromHand, toPlayer, toHand));
                            }
                        }
                    }
                }
            }
        }
        return possibleMoves;
    }

    public ChopsticksGameState applyMove(Move move) {
        int[] newPlayer1Hands = player1Hands.clone();
        int[] newPlayer2Hands = player2Hands.clone();

        int fromPlayer = move.getFromPlayer();
        int fromHand = move.getFromHand();
        int toPlayer = move.getToPlayer();
        int toHand = move.getToHand();

        if (fromPlayer == 1) {
            newPlayer1Hands[fromHand] = (newPlayer1Hands[fromHand] + newPlayer2Hands[toHand]) % 5;
        } else {
            newPlayer2Hands[fromHand] = (newPlayer2Hands[fromHand] + newPlayer1Hands[toHand]) % 5;
        }

        return new ChopsticksGameState(newPlayer1Hands, newPlayer2Hands);
    }

    public ChopsticksGameState(int[] player1Hands, int[] player2Hands) {
        this.player1Hands = player1Hands.clone();
        this.player2Hands = player2Hands.clone();
    }

    public int[] getPlayer1Hands() {
        return player1Hands.clone();
    }

    public int[] getPlayer2Hands() {
        return player2Hands.clone();
    }

    public boolean isValidMove(int fromPlayer, int fromHand, int toPlayer, int toHand) {
        // Check if the move is valid
        int[] fromHands, toHands;
        if (fromPlayer == 1) {
            fromHands = player1Hands;
        } else if (fromPlayer == 2) {
            fromHands = player2Hands;
        } else {
            return false; // Invalid fromPlayer
        }

        if (toPlayer == 1) {
            toHands = player1Hands;
        } else if (toPlayer == 2) {
            toHands = player2Hands;
        } else {
            return false; // Invalid toPlayer
        }

        if (fromHand < 0 || fromHand >= fromHands.length || toHand < 0 || toHand >= toHands.length) {
            return false; // Invalid hand indices
        }
        if (fromPlayer == toPlayer && fromHand == toHand) {
            return false; // Cannot transfer fingers to the same hand
        }
        if (fromHands[fromHand] == 0) {
            return false; // Cannot transfer fingers from an empty hand
        }
        if (toHands[toHand] >= 5) {
            return false; // Cannot transfer fingers to a hand with 5 fingers
        }
        return true;
    }

    public ChopsticksGameState applyMove(int fromPlayer, int fromHand, int toPlayer, int toHand) {
        // Apply the move and return a new game state
        if (!isValidMove(fromPlayer, fromHand, toPlayer, toHand)) {
            return null; // Invalid move
        }
        int[] newPlayer1Hands = player1Hands.clone();
        int[] newPlayer2Hands = player2Hands.clone();

        if (fromPlayer == 1) {
            newPlayer1Hands[fromHand] = (newPlayer1Hands[fromHand] + newPlayer2Hands[toHand]) % 5;
        } else {
            newPlayer2Hands[fromHand] = (newPlayer2Hands[fromHand] + newPlayer1Hands[toHand]) % 5;
        }

        return new ChopsticksGameState(newPlayer1Hands, newPlayer2Hands);
    }

    @Override
    public String toString() {
        return "ChopsticksGameState{" +
                "player1Hands=" + Arrays.toString(player1Hands) +
                ", player2Hands=" + Arrays.toString(player2Hands) +
                '}';
    }

    public boolean isValidMove(Move move) {
        int fromPlayer = move.getFromPlayer();
        int fromHand = move.getFromHand();
        int toPlayer = move.getToPlayer();
        int toHand = move.getToHand();
        
        // Delegate to the existing isValidMove method with extracted parameters
        return isValidMove(fromPlayer, fromHand, toPlayer, toHand);
    }
    

    public static void main(String[] args) {
        // Example usage:
        int[] initialPlayer1Hands = {1, 1}; // Initial state with 1 finger on each hand for player 1
        int[] initialPlayer2Hands = {1, 1}; // Initial state with 1 finger on each hand for player 2
        ChopsticksGameState initialState = new ChopsticksGameState(initialPlayer1Hands, initialPlayer2Hands);
        System.out.println("Initial state: " + initialState);

        // Example move: Player 1 transfers fingers from hand 0 to player 2's hand 1
        int fromPlayer = 1;
        int fromHand = 0;
        int toPlayer = 2;
        int toHand = 1;
        ChopsticksGameState newState = initialState.applyMove(fromPlayer, fromHand, toPlayer, toHand);
        if (newState != null) {
            System.out.println("New state after move: " + newState);
        } else {
            System.out.println("Invalid move.");
        }
    }
}
