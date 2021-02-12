import java.time.LocalTime;
import java.util.Objects;

class CourseSection
{
   private final String prefix;
   private final String number;
   private final int enrollment;
   private final LocalTime startTime;
   private final LocalTime endTime;

   public CourseSection(final String prefix, final String number,
      final int enrollment, final LocalTime startTime, final LocalTime endTime)
   {
      this.prefix = prefix;
      this.number = number;
      this.enrollment = enrollment;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      CourseSection that = (CourseSection) o;
      return enrollment == that.enrollment && Objects.equals(prefix, that.prefix) && Objects.equals(number, that.number) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
   }

   @Override
   public int hashCode() {
      return Objects.hash(prefix, number, enrollment, startTime, endTime);
   }

   // additional likely methods not defined since they are not needed for testing
}
