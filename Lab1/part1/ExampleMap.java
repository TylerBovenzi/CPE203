import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ExampleMap
{
   public static List<String> highEnrollmentStudents(
      Map<String, List<Course>> courseListsByStudentName, int unitThreshold)
   {
      List<String> overEnrolledStudents = new LinkedList<>();

      for(String key: courseListsByStudentName.keySet()) {
         int units = 0;
         for (Course c:courseListsByStudentName.get(key)){
            units+=c.getNumUnits();
         }
         if(units>unitThreshold){
            overEnrolledStudents.add(key);
         }
      }
      return overEnrolledStudents;      
   }
}
