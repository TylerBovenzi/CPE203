public class Util {

    public static double perimeter(Circle circle){
        return Math.PI*2*circle.getRadius();
    }

    public static double perimeter(Rectangle rectangle){
        return (Math.abs(rectangle.getTopLeft().getX()-rectangle.getBottomRight().getX()*2)+
                (Math.abs(rectangle.getTopLeft().getY()-rectangle.getBottomRight().getY())*2));
    }

    public static double perimeter(Polygon polygon){
        double ans = 0.0;
        for(int i = 0; i < polygon.getPoints().size()-1;i++){
            double dX = polygon.getPoints().get(i).getX()-polygon.getPoints().get(i+1).getX();
            double dY = polygon.getPoints().get(i).getY()-polygon.getPoints().get(i+1).getY();
            ans += Math.sqrt(dX*dX+dY*dY);
        }

        double dX = polygon.getPoints().get(0).getX()-polygon.getPoints().get(polygon.getPoints().size()-1).getX();
        double dY = polygon.getPoints().get(0).getY()-polygon.getPoints().get(polygon.getPoints().size()-1).getY();
        ans += Math.sqrt(dX*dX+dY*dY);
        return ans;
    }

}
