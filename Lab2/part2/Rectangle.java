public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight){
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public double perimeter() {
        return Math.abs((this.getTopLeft().getX()-this.getBottomRight().getX()*2)+
                ((this.getTopLeft().getY()-this.getBottomRight().getY())*2));
    }
}
