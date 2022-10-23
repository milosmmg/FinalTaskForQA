public class Student {
    private String studentName;
    private String studentOccupation;
    private int numberOfCourses;


    public Student(String studentName, String studentOccupation, int numberOfCourses) {
        this.studentName = studentName;
        this.studentOccupation = studentOccupation;
        this.numberOfCourses = numberOfCourses;
    }


    public String getStudentName() {
        return studentName;
    }

    public String getStudentOccupation() {
        return studentOccupation;
    }

    public int getStudentnumberOfCourses() {
        return numberOfCourses;
    }

    public static String report(String choice){

        return (choice.equals("") || choice.equals("0"))?"Short":"Long";

    }

}
