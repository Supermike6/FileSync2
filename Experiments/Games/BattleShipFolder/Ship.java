
import java.awt.Point;

public class Ship
{
    private int playerNum;
    private int shipSize;
    private Point topLeftChord;
    private boolean facingDown;

    public Ship(int playerNum, int shipSize, Point topLeftChord, boolean facingDown) {
        this.playerNum = playerNum;
        this.shipSize = shipSize;
        this.topLeftChord = topLeftChord;
        this.facingDown = facingDown;
    }

    public int getPlayerNum() {
        return playerNum;
    }
    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
    public int getShipSize() {
        return shipSize;
    }
    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }
    public Point getTopLeftChord() {
        return topLeftChord;
    }
    public void setTopLeftChord(Point topLeftChord) {
        this.topLeftChord = topLeftChord;
    }
    public boolean isFacingDown() {
        return facingDown;
    }
    public void setFacingDown(boolean facingDown) {
        this.facingDown = facingDown;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + playerNum;
        result = prime * result + shipSize;
        result = prime * result + ((topLeftChord == null) ? 0 : topLeftChord.hashCode());
        result = prime * result + (facingDown ? 1231 : 1237);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ship other = (Ship) obj;
        if (playerNum != other.playerNum)
            return false;
        if (shipSize != other.shipSize)
            return false;
        if (topLeftChord == null) {
            if (other.topLeftChord != null)
                return false;
        } else if (!topLeftChord.equals(other.topLeftChord))
            return false;
        if (facingDown != other.facingDown)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Ship [playerNum=" + playerNum + ", shipSize=" + shipSize + ", topLeftChord=" + topLeftChord
                + ", facingDown=" + facingDown + "]";
    }
}
