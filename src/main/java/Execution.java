import java.time.LocalDateTime;
import java.util.*;

public class Execution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Student student1 = new Student("Ivanov Ivan", "Java developer", 3);
        Student student2 = new Student("Sidorov Ivan", "AQE", 3);
        Student student3 = new Student("Jovana Jovanovic", "Design", 5);

        List<Course> firstStudentCourses = new ArrayList<>();
        List<Course> secondStudentCourses = new ArrayList<>();
        List<Course> thirdStudentCourses = new ArrayList<>();

        firstStudentCourses.add(new Course("Java", 8));
        firstStudentCourses.add(new Course("JDBC", 8));
        firstStudentCourses.add(new Course("Spring", 16));
        secondStudentCourses.add(new Course("Test Design", 10));
        secondStudentCourses.add(new Course("Page Object", 10));
        secondStudentCourses.add(new Course("Selenium", 20));
        thirdStudentCourses.add(new Course("Blender", 24));
        thirdStudentCourses.add(new Course("Sculpting", 72));
        thirdStudentCourses.add(new Course("Blender intro", 8));
        thirdStudentCourses.add(new Course("Object preview", 8));
        thirdStudentCourses.add(new Course("3D environment", 32));
        
        
        

        LocalDateTime startTimeFirstStudent = LocalDateTime.of(2022, 10, 8, 13, 54);
        LocalDateTime startTimeSecondStudent = LocalDateTime.of(2022, 10, 18, 13, 55);
        LocalDateTime startTimeThirdStudent = LocalDateTime.of(2022, 10, 01, 11, 24);


        System.out.println(startTimeFirstStudent);
        int student1CourseDurationInMinutes = Course.timeUntilCourseEnds(startTimeFirstStudent);
        System.out.println(student1CourseDurationInMinutes);
        int student2CourseDurationInMinutes = Course.timeUntilCourseEnds(startTimeSecondStudent);
        System.out.println(student2CourseDurationInMinutes);
        int student3CourseDurationInMinutes = Course.timeUntilCourseEnds(startTimeThirdStudent);
        System.out.println(student3CourseDurationInMinutes);

        System.out.println("Choose report type, type 0 for Short or anything else for Long report");
        String reportType = input.nextLine();

        Report.report(student1, firstStudentCourses, Student.report(reportType), startTimeFirstStudent);
        Report.report(student2, secondStudentCourses, Student.report(reportType), startTimeSecondStudent);
        Report.report(student3, thirdStudentCourses, Student.report(reportType), startTimeThirdStudent);
    }
}