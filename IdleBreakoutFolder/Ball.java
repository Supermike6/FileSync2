package IdleBreakoutFolder;

public class Ball {
    
    private double x, y;
    private int width, height;
    private int power, speed;
    private String name, desc;

    public Ball(double x, double y, int width, int height, int power, int speed, String name, String desc) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.power = power;
        this.speed = speed;
        this.name = name;
        this.desc = desc;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + width;
        result = prime * result + height;
        result = prime * result + power;
        result = prime * result + speed;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((desc == null) ? 0 : desc.hashCode());
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
        Ball other = (Ball) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
            return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
            return false;
        if (width != other.width)
            return false;
        if (height != other.height)
            return false;
        if (power != other.power)
            return false;
        if (speed != other.speed)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (desc == null) {
            if (other.desc != null)
                return false;
        } else if (!desc.equals(other.desc))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "ball [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + ", power=" + power + ", speed="
                + speed + ", name=" + name + ", desc=" + desc + "]";
    }

}
