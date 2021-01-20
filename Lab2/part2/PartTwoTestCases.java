import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class PartTwoTestCases
{
   public static final double DELTA = 0.00001;

   @Test
   public void testCircleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getCenter", "getRadius", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, double.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0], new Class[0]);

      verifyImplSpecifics(Circle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testRectangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getTopLeft", "getBottomRight", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Point.class, Point.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0], new Class[0]);

      verifyImplSpecifics(Rectangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testPolygonImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getPoints", "perimeter");

      final List<Class> expectedMethodReturns = Arrays.asList(
         List.class, double.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[0]);

      verifyImplSpecifics(Polygon.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals("Unexpected number of public fields",
         0, clazz.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertEquals("Unexpected number of public methods",
         expectedMethodNames.size(), publicMethods.size());

      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }

   @Test
   public void testCirclePerimeter()
   {
      Point center = new Point(0,0);
      double radius = 3.0;
      Circle circle = new Circle(center, radius);
      double expectedPerimeter = 2*radius*Math.PI;
      assertEquals(circle.perimeter(), expectedPerimeter, DELTA);
   }

   @Test
   public void testCirclePerimeter2()
   {
      Point center = new Point(0,3);
      double radius = 2.0;
      Circle circle = new Circle(center, radius);
      double expectedPerimeter = 2*radius*Math.PI;
      assertEquals(circle.perimeter(), expectedPerimeter, DELTA);
   }

   @Test
   public void testRectanglePerimeter()
   {
      Point tl = new Point(1,3);
      Point br = new Point(3,0);
      Rectangle rectangle = new Rectangle(tl,br);
      double expectedPerimeter = 10.0;
      assertEquals(rectangle.perimeter(), expectedPerimeter, DELTA);
   }


   @Test
   public void testRectanglePerimeter2()
   {
      Point tl = new Point(1,3);
      Point br = new Point(5,-2);
      Rectangle rectangle = new Rectangle(tl,br);
      double expectedPerimeter = 18.0;
      assertEquals(rectangle.perimeter(), expectedPerimeter, DELTA);
   }

   @Test
   public void testPolygonPerimeter()
   {

      List <Point>points = new ArrayList< Point >();
      points.add(new Point(0, 0));
      points.add(new Point(3,0));
      points.add(new Point(0,4));
      Polygon polygon = new Polygon(points);
      double expectedPerimeter = 12.0;
      assertEquals(polygon.perimeter(), expectedPerimeter, DELTA);
   }
   @Test
   public void testPolygonPerimeter2()
   {

      List <Point>points = new ArrayList< Point >();
      points.add(new Point(0, 0));
      points.add(new Point(12,0));
      points.add(new Point(0,5));
      Polygon polygon = new Polygon(points);
      double expectedPerimeter = 30.0;
      assertEquals(polygon.perimeter(), expectedPerimeter, DELTA);
   }

   @Test
   public void testBigger()
   {
      Point center = new Point(0,0);
      double radius = 3.0;
      Circle circle = new Circle(center, radius);

      Point tl = new Point(1,3);
      Point br = new Point(3,0);
      Rectangle rectangle = new Rectangle(tl,br);

      List <Point>points = new ArrayList< Point >();
      points.add(new Point(0, 0));
      points.add(new Point(3,0));
      points.add(new Point(0,4));
      Polygon polygon = new Polygon(points);

      assertEquals(6*Math.PI, Bigger.whichIsBigger(circle,rectangle, polygon), DELTA);

   }

   @Test
   public void testBigger2()
   {
      Point center = new Point(0,1);
      double radius = 2.0;
      Circle circle = new Circle(center, radius);

      Point tl = new Point(1,3);
      Point br = new Point(5,-2);
      Rectangle rectangle = new Rectangle(tl,br);

      List <Point>points = new ArrayList< Point >();
      points.add(new Point(0, 0));
      points.add(new Point(12,0));
      points.add(new Point(0,5));
      Polygon polygon = new Polygon(points);

      assertEquals(30.0, Bigger.whichIsBigger(circle,rectangle, polygon), DELTA);

   }
}
