package breakout.model;

/*
        A wall for the ball to bounce
 */
public class Wall extends Sprite implements IPositionable{

    Dir direction;

    public Wall(double x, double y, Dir dir){
        super(x,y);
        direction = dir;
        height = 400;
        width = 400;

    }

    @Override
    public double getWidth() {
        if (direction == Dir.HORIZONTAL){
            return width;
        }
        else{
            return 1;
        }
    }

    @Override
    public double getHeight() {
        if (direction == Dir.VERTICAL){
            return height;
        }
        else {
            return 1;
        }
    }

    public enum Dir {
        HORIZONTAL, VERTICAL
    }

}
