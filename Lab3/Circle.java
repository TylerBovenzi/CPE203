import java.awt.Color;
import java.awt.Point;
import java.util.Objects;


public class Circle implements Shape {

private double radius;
private Point center;
private Color color;

    public Circle(double radius, Point center, Color color){
        this.radius = radius;
        this.center=center;
        this.color=color;
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public double getArea(){
        return Math.PI* getRadius() * getRadius();
    }

    public double getPerimeter(){
        return Math.PI*2* getRadius();
    }

    public void translate(Point P){
        final double X = this.center.getX() + P.getX();
        final double Y = this.center.getY() + P.getY();
        this.center = new Point((int)X, (int)Y);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter(){
        return this.center;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && Objects.equals(center, circle.center) && Objects.equals(color, circle.color);
    }

}
