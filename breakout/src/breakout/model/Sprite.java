package breakout.model;

public abstract class Sprite {
    double width;
    double height;

    double x;
    double y;

    double dx;
    double dy;

    public Sprite(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


}
