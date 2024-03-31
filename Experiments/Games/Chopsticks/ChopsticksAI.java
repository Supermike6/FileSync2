package Chopsticks;

public class ChopsticksAI {
    public static Move findBestMove(ChopsticksGameState state, int depth, int player) {
        int bestScore = player == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        Move bestMove = null;
        for (Move move : state.generatePossibleMoves()) {
            ChopsticksGameState newState = state.applyMove(move);
            int score = minimax(newState, depth, Integer.MIN_VALUE, Integer.MAX_VALUE, player == 1 ? false : true);
            if ((player == 1 && score > bestScore) || (player == 2 && score < bestScore)) {
                bestScore = score;
                bestMove = move;
            }
        }
        return bestMove;
    }

    private static int minimax(ChopsticksGameState state, int depth, int alpha, int beta, boolean maximizingPlayer) {
        if (depth == 0 || isTerminalState(state)) {
            return evaluate(state);
        }

        if (maximizingPlayer) {
            int maxScore = Integer.MIN_VALUE;
            for (Move move : state.generatePossibleMoves()) {
                ChopsticksGameState newState = state.applyMove(move);
                int score = minimax(newState, depth - 1, alpha, beta, false);
                maxScore = Math.max(maxScore, score);
                alpha = Math.max(alpha, score);
                if (beta <= alpha) {
                    break; // Beta cutoff
                }
            }
            return maxScore;
        } else {
            int minScore = Integer.MAX_VALUE;
            for (Move move : state.generatePossibleMoves()) {
                ChopsticksGameState newState = state.applyMove(move);
                int score = minimax(newState, depth - 1, alpha, beta, true);
                minScore = Math.min(minScore, score);
                beta = Math.min(beta, score);
                if (beta <= alpha) {
                    break; // Alpha cutoff
                }
            }
            return minScore;
        }
    }

    private static boolean isTerminalState(ChopsticksGameState state) {
        int[] player1Hands = state.getPlayer1Hands();
        int[] player2Hands = state.getPlayer2Hands();
    
        boolean player1Lost = player1Hands[0] == 0 && player1Hands[1] == 0;
        boolean player2Lost = player2Hands[0] == 0 && player2Hands[1] == 0;
    
        return player1Lost || player2Lost;
    }
    

    public static int evaluate(ChopsticksGameState state) {
        int[] player1Hands = state.getPlayer1Hands();
        int[] player2Hands = state.getPlayer2Hands();
    
        // Check if player 1 has lost
        if (player1Hands[0] == 0 && player1Hands[1] == 0) {
            return Integer.MIN_VALUE; // Player 1 has lost, so this state is very unfavorable for the computer player
        }
    
        // Check if player 2 has lost
        if (player2Hands[0] == 0 && player2Hands[1] == 0) {
            return Integer.MAX_VALUE; // Player 2 has lost, so this state is very favorable for the computer player
        }
    
        // Otherwise, calculate a score based on the difference in fingers between the players
        int player1Fingers = player1Hands[0] + player1Hands[1];
        int player2Fingers = player2Hands[0] + player2Hands[1];
        return player2Fingers - player1Fingers; // Positive score indicates favorable state for computer player
    }

    public static void main(String[] args) {
        // Example game state
        int[] player1Hands = {1, 1};
        int[] player2Hands = {1, 1};
        ChopsticksGameState gameState = new ChopsticksGameState(player1Hands, player2Hands);

        // Example search depth
        int searchDepth = 4;

        // Find the best moves for both players
        Move player1Move = findBestMove(gameState, searchDepth, 1);
        Move player2Move = findBestMove(gameState, searchDepth, 2);

        // Convert moves to Chopsticks notation
        String recommendedMovePlayer1 = ChopsticksNotation.moveToString(player1Move);
        String recommendedMovePlayer2 = ChopsticksNotation.moveToString(player2Move);

        // Print recommended moves
        System.out.println("Recommended move for Player 1: " + recommendedMovePlayer1);
        System.out.println("Recommended move for Player 2: " + recommendedMovePlayer2);
    }
}
