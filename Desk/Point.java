package Desk;

public class Point implements Cloneable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int value) {
        x = value;
    }

    public void setY(int value) {
        y = value;
    }

    public boolean equals(Point other) {
        return x == other.x && y == other.y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int distance(Point other) {
        return (int)Math.hypot(x-other.x, y-other.y);
    }

    public Point clone() throws CloneNotSupportedException {
        return (Point) super.clone();
    }
}
