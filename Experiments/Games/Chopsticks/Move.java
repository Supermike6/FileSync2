package Chopsticks;

public class Move {
    private int fromPlayer;
    private int fromHand;
    private int toPlayer;
    private int toHand;

    public Move(int fromPlayer, int fromHand, int toPlayer, int toHand) {
        this.fromPlayer = fromPlayer;
        this.fromHand = fromHand;
        this.toPlayer = toPlayer;
        this.toHand = toHand;
    }

    public int getFromPlayer() {
        return fromPlayer;
    }

    public int getFromHand() {
        return fromHand;
    }

    public int getToPlayer() {
        return toPlayer;
    }

    public int getToHand() {
        return toHand;
    }

    @Override
    public String toString() {
        return "Move{" +
                "fromPlayer=" + fromPlayer +
                ", fromHand=" + fromHand +
                ", toPlayer=" + toPlayer +
                ", toHand=" + toHand +
                '}';
    }
}
