import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.*;

public class Execution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        Student student1 = new Student("Ivanov Ivan", "Java developer", 3);
        Student student2 = new Student("Sidorov Ivan", "AQE", 3);
        Student student3 = new Student("Jovana Jovanovic", "Design", 5);

        List<Course> firstStudentCourses = new ArrayList<>();
        List<Course> secondStudentCourses = new ArrayList<>();
        List<Course> thirdStudentCourses = new ArrayList<>();

        firstStudentCourses.add(new Course("Java", 8));
        firstStudentCourses.add(new Course("JDBC", 8));
        firstStudentCourses.add(new Course("Spring", 16));
        secondStudentCourses.add(new Course("Test Design", 9));
        secondStudentCourses.add(new Course("Page Object", 8));
        secondStudentCourses.add(new Course("Selenium", 12));
        thirdStudentCourses.add(new Course("Blender", 21));
        thirdStudentCourses.add(new Course("Sculpting", 70));
        thirdStudentCourses.add(new Course("Blender intro", 5));
        thirdStudentCourses.add(new Course("Object preview", 9));
        thirdStudentCourses.add(new Course("3D environment", 30));


//        LocalDateTime startTimeFirstStudent = LocalDateTime.of(2022, 10, 8, 13, 54);
//        LocalDateTime startTimeSecondStudent = LocalDateTime.of(2022, 10, 18, 13, 55);
//        LocalDateTime startTimeThirdStudent = LocalDateTime.of(2022, 10, 01, 11, 24);

        System.out.println("Enter course start date in format YYYY/MM/d/h/m");
        LocalDateTime startCourseDate = LocalDateTime.of(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());
        isDateValid(startCourseDate); 

        System.out.println("Choose report type, type 0 for Short or anything else for Long report");
        String reportType = input2.nextLine();

        Report.report(student1, firstStudentCourses, Student.report(reportType), startCourseDate);
        Report.report(student2, secondStudentCourses, Student.report(reportType), startCourseDate);
        Report.report(student3, thirdStudentCourses, Student.report(reportType), startCourseDate);
    }

    public static boolean isDateValid(LocalDateTime time) {
        try {
            LocalDateTime.of(time.getYear(), time.getMonth(), time.getDayOfMonth(), time.getHour(), time.getMinute());
        } catch (Exception e) {
            System.out.println("Wrong date format");
            return false;
        }
        return true;
    }
}