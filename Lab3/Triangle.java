import java.awt.*;
import java.util.Objects;

public class Triangle implements Shape {

    private Color color;
    private Point a,b,c;

    public Triangle(Point a, Point b, Point c, Color color){
        this.a=a;
        this.b=b;
        this.c=c;
        this.color=color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public double getArea() {
        double lenA = Math.sqrt(Math.pow(a.getX()- b.getX(),2.0) +Math.pow(a.getY()- b.getY(),2.0));
        double lenB = Math.sqrt(Math.pow(b.getX()- c.getX(),2.0) +Math.pow(b.getY()- c.getY(),2.0));
        double lenC = Math.sqrt(Math.pow(c.getX()- a.getX(),2.0) +Math.pow(c.getY()- a.getY(),2.0));
        double p = this.getPerimeter()/2.0;

        return Math.sqrt(p*(p-lenA)*(p-lenB)*(p-lenC));
    }

    public double getPerimeter() {
        double lenA = Math.sqrt(Math.pow(a.getX()- b.getX(),2.0) +Math.pow(a.getY()- b.getY(),2.0));
        double lenB = Math.sqrt(Math.pow(b.getX()- c.getX(),2.0) +Math.pow(b.getY()- c.getY(),2.0));
        double lenC = Math.sqrt(Math.pow(c.getX()- a.getX(),2.0) +Math.pow(c.getY()- a.getY(),2.0));
        return lenA+lenB+lenC;
    }

    public void translate(Point P) {
        this.a = new Point((int)(a.getX()+P.getX()),(int)(a.getY()+P.getY()));
        this.b = new Point((int)(b.getX()+P.getX()),(int)(b.getY()+P.getY()));
        this.c = new Point((int)(c.getX()+P.getX()),(int)(c.getY()+P.getY()));
    }

    public Point getVertexA(){
        return this.a;
    }

    public Point getVertexB(){
        return this.b;
    }

    public Point getVertexC(){
        return this.c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(color, triangle.color) && Objects.equals(a, triangle.a) && Objects.equals(b, triangle.b) && Objects.equals(c, triangle.c);
    }


}
