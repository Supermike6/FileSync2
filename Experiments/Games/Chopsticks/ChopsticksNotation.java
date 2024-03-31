package Chopsticks;

public class ChopsticksNotation {
    public static String moveToString(Move move) {
        String out = "";
        out += ('A' + move.getFromHand() - 1); // Convert hand number to character (A, B, C, ...)
        out += move.getFromPlayer();
        out += (char)('A' + move.getToHand() - 1);
        out += move.getToPlayer();
        return out;
    }

    public static Move stringToMove(String notation) {
        int fromHand = notation.charAt(0) - 'A' + 1; // Convert character to hand number (1, 2, 3, ...)
        int fromPlayer = Character.getNumericValue(notation.charAt(1));
        int toHand = notation.charAt(2) - 'A' + 1;
        int toPlayer = Character.getNumericValue(notation.charAt(3));
        return new Move(fromPlayer, fromHand, toPlayer, toHand);
    }

    public static void main(String[] args) {
        // Example usage
        Move move = new Move(1, 1, 2, 2);
        String notation = moveToString(move);
        System.out.println("Move notation: " + notation); // Output: Move notation: A1B2
        Move parsedMove = stringToMove(notation);
        System.out.println("Parsed move: " + parsedMove); // Output: Parsed move: Move{fromPlayer=1, fromHand=1, toPlayer=2, toHand=2}
    }
}
