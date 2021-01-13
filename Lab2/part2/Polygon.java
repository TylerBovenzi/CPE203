import java.util.List;

public class Polygon {
    private List<Point> points;

    public Polygon(List<Point> points){
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public double perimeter(){
        double ans = 0.0;
        for(int i = 0; i < this.getPoints().size()-1;i++){
            double dX = this.getPoints().get(i).getX()-this.getPoints().get(i+1).getX();
            double dY = this.getPoints().get(i).getY()-this.getPoints().get(i+1).getY();
            ans += Math.sqrt(dX*dX+dY*dY);
        }

        double dX = this.getPoints().get(0).getX()-this.getPoints().get(this.getPoints().size()-1).getX();
        double dY = this.getPoints().get(0).getY()-this.getPoints().get(this.getPoints().size()-1).getY();
        ans += Math.sqrt(dX*dX+dY*dY);
        return ans;
    }
}
