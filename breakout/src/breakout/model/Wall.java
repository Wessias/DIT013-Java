package breakout.model;

/*
        A wall for the ball to bounce
 */
public class Wall extends Sprite implements IPositionable{

    private final Dir direction;

    public Wall(double x, double y, Dir dir){
        super(x,y, 400, 400);
        direction = dir;

    }

    @Override
    public double getWidth() {
        if (direction == Dir.HORIZONTAL){
            return super.getWidth();
        }
        else{
            return 1;
        }
    }

    @Override
    public double getHeight() {
        if (direction == Dir.VERTICAL){
            return super.getHeight();
        }
        else {
            return 1;
        }
    }

    public enum Dir {
        HORIZONTAL, VERTICAL
    }

}
