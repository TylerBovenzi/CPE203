public class Bigger {
    public static double whichIsBigger(Circle circle, Rectangle rectangle, Polygon polygon){
        final double circleP = Util.perimeter(circle);
        final double rectP = Util.perimeter(rectangle);
        final double polyP = Util.perimeter(polygon);
        return Math.max(circleP,Math.max(rectP,polyP));
    }
}
