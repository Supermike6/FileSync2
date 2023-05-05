package IdleBreakoutFolder;

public class Brick {
    private int  health;
    private boolean poisoned, black;
   
    public Brick(int health, boolean poisoned, boolean black) {
        this.health = health;
        this.poisoned = poisoned;
        this.black = black;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isPoisoned() {
        return poisoned;
    }

    public void setPoisoned(boolean poisoned) {
        this.poisoned = poisoned;
    }

    public boolean isBlack() {
        return black;
    }

    public void setBlack(boolean black) {
        this.black = black;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + health;
        result = prime * result + (poisoned ? 1231 : 1237);
        result = prime * result + (black ? 1231 : 1237);
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
        Brick other = (Brick) obj;
        if (health != other.health)
            return false;
        if (poisoned != other.poisoned)
            return false;
        if (black != other.black)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Brick [health=" + health + ", poisoned=" + poisoned + ", black=" + black + "]";
    }

    


}
