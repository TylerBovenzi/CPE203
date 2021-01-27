import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class WorkSpace {
    private ArrayList<Shape> shapes;

    public WorkSpace(){
        shapes = new ArrayList<>();
    }

    public void add(Shape shape){
        shapes.add(shape);
    }

    public Shape get(int index){
        return shapes.get(index);
    }

    public int size(){
        return shapes.size();
    }

    public List<Circle> getCircles(){
        ArrayList<Circle> circles = new ArrayList<>();
        for (Shape shape: shapes){
            if(shape instanceof Circle){
                circles.add((Circle) shape);
            }
        }
        return circles;
    }

    public List<Rectangle> getRectangles(){
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        for (Shape shape: shapes){
            if(shape instanceof Rectangle){
                rectangles.add((Rectangle) shape);
            }
        }
        return rectangles;
    }

    public List<Triangle> getTriangles(){
        ArrayList<Triangle> triangles = new ArrayList<>();
        for (Shape shape: shapes){
            if(shape instanceof Triangle){
                triangles.add((Triangle) shape);
            }
        }
        return triangles;
    }

    public List<Shape> getShapesByColor(Color color){
        ArrayList<Shape> moreShapes = new ArrayList<>();
        for (Shape shape: shapes){
            if(shape.getColor().equals(color)){
                moreShapes.add(shape);
            }
        }
        return moreShapes;
    }

    public double getAreaOfAllShapes(){
        double net = 0;
        for (Shape shape: shapes){
            net+=shape.getArea();
        }
        return net;
    }

    public double getPerimeterOfAllShapes(){
        double net = 0;
        for (Shape shape: shapes){
            net+=shape.getPerimeter();
        }
        return net;
    }
}
