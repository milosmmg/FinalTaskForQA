import java.time.LocalDateTime;
import java.util.List;

public class Report {

    public static void report(Student student, List<Course> course, String reportType, LocalDateTime time) {
        
        if (reportType.equals("Short")) {
            System.out.println(student.getStudentName() + " ( " + student.getStudentOccupation() +
                    " ) " + Course.courseReport(Course.courseTimeDuration(course), Course.timeUntilCourseEnds(time)/60));
        }
        else if (reportType.equals("Long")) {
            System.out.println("Student name: " + student.getStudentName());
            System.out.println("working time (from 10 to 18)");
            System.out.println("Program name: " + student.getStudentOccupation());
            System.out.println("Program duration: " + Course.courseTimeDuration(course) / 8 + "d " + Course.courseTimeDuration(course) % 8 + "h");
            System.out.println("Program duration in hours: " + Course.courseTimeDuration(course));
            System.out.println("Start date: " +time);
            System.out.println("End date: " + Course.courseEndTime(course, time));
            System.out.println(Course.courseReport(Course.courseTimeDuration(course), Course.timeUntilCourseEnds(time)/60));
        }
    }


}

