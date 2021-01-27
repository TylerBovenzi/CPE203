import java.awt.*;
import java.util.Objects;

public class Rectangle implements Shape{
private double width;
private double height;
private Point topLeft;
private Color color;

    public Rectangle(double width, double height, Point topLeft, Color color){
        this.width = width;
        this.height = height;
        this.topLeft = topLeft;
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color=color;
    }

    public double getArea() {
        return Math.abs(getWidth() * getHeight());
    }

    public double getPerimeter() {
        return Math.abs(2* getWidth())+Math.abs(2* getHeight());
    }


    public void translate(Point P) {
        final double X = this.getTopLeft().getX() + P.getX();
        final double Y = this.getTopLeft().getY() + P.getY();
        this.topLeft = new Point((int)X, (int)Y);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 && Double.compare(rectangle.height, height) == 0 && Objects.equals(topLeft, rectangle.topLeft) && Objects.equals(color, rectangle.color);
    }

}
