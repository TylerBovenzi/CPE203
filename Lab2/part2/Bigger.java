public class Bigger {
    public static double whichIsBigger(Circle circle, Rectangle rectangle, Polygon polygon){
        final double circleP = circle.perimeter();
        final double rectP = rectangle.perimeter();
        final double polyP = polygon.perimeter();
        return Math.max(circleP,Math.max(rectP,polyP));
    }
}
