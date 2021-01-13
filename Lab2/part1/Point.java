import java.io.PipedInputStream;

public class Point {

    private final double x, y;

    public Point(double v, double v1) {
        x=v;y=v1;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle(){
        return Math.atan2(y,x);
    }

    public double getRadius(){
        return Math.pow(Math.pow(x,2)+Math.pow(y,2), .5);
    }

    public Point rotate90(){
        return new Point(-this.getY(),this.getX());
    }
}

