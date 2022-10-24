import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Course {

    private String courseName;
    private int courseDuration;

    public Course(String courseName, int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Course() {
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseDuration() {
        return courseDuration;
    }


    public static int timeUntilCourseEnds(LocalDateTime setDate) {
        LocalDateTime currentDate = LocalDateTime.now();
        int courseHours = 0;
        int courseMins = 0;

        if (setDate.getDayOfWeek().getValue() < 6) {
            if (setDate.getHour() < 10) {
                courseHours = 0;
                courseMins = 0;
            } else if (setDate.getHour() < 18) {
                if (Course.isSameDay(setDate, currentDate)) {
                    courseHours = currentDate.getHour() - setDate.getHour();
                    if (currentDate.getMinute() - setDate.getMinute() >= 0)
                        courseMins = currentDate.getMinute() - setDate.getMinute();
                    else {
                        courseMins = 60 + currentDate.getMinute() - setDate.getMinute();
                        courseHours -= 1;
                    }
                } else {
                    courseHours = 17 - setDate.getHour();
                    courseMins = 60 - setDate.getMinute();
                }
            } else {
                courseHours = 8;
            }
        }
        if (Course.isSameDay(setDate, currentDate))
            return courseHours * 60 + courseMins;
        else
            setDate = setDate.plusDays(1);

        while (setDate.isBefore(currentDate) && !Course.isSameDay(setDate, currentDate)) {
            if (setDate.getDayOfWeek().getValue() < 6)
                courseHours += 8;
            setDate = setDate.plusDays(1);
        }

        if (currentDate.getDayOfWeek().getValue() < 6 && Course.isSameDay(setDate, currentDate)) {
            if (currentDate.getHour() <= 10) return courseHours * 60 + courseMins;
            else if (currentDate.getHour() < 18) {
                courseHours += currentDate.getHour() - 10;
                courseMins += currentDate.getMinute();
            } else courseHours += 8;
        }
        return courseHours * 60 + courseMins;
    }

    public static int courseTimeDuration(List<Course> courses) {
        int tempDuration = 0;
        for (Course l : courses) {
            tempDuration += l.getCourseDuration();
        }
        return tempDuration;
    }

    public static String courseReport(int duration, int timeElapsed) {
        String tempString = "";
        if (duration > timeElapsed)
            tempString = "Training is not finished. " + (duration - timeElapsed) / 8 + " day/s and " +
                    (duration - timeElapsed) % 8 + " hours are left until the end of course.";
        else
            tempString = "Trainig completed. " + (timeElapsed - duration) / 8 + " working day/s and " + (timeElapsed - duration) % 8 +
                    " hours have passed since course was finished.";
        return tempString;
    }

    private static boolean isSameDay(LocalDateTime date1, LocalDateTime date2) {
        if (date1.getYear() == date2.getYear() && date1.getMonth() == date2.getMonth() && date1.getDayOfMonth() == date2.getDayOfMonth())
            return true;
        else
            return false;
    }

    public static LocalDateTime courseStartTime(LocalDateTime startDate){
     LocalDateTime tempDate = startDate;
     if (tempDate.getDayOfWeek().getValue() == 6 )
         return tempDate.plusDays(2).withHour(10).withMinute(0);
     else if (tempDate.getDayOfWeek().getValue() == 7 )
         return tempDate.plusDays(1).withHour(10).withMinute(0);
     else if (tempDate.getHour()<10)
         return  tempDate.withHour(10).withMinute(0);
     else if (tempDate.getHour()<18)
         return tempDate;
     else if (tempDate.getDayOfWeek().getValue() < 5)
         return tempDate.plusDays(1).withHour(10).withMinute(0);
     else return tempDate.plusDays(3).withHour(10).withMinute(0);
    }
    
    public static LocalDateTime courseEndTime(List<Course> courses, LocalDateTime startDate) {
        LocalDateTime tempDate = startDate;
        int hoursLeft = courseTimeDuration(courses);
        if (tempDate.getHour() < 10)
            tempDate = tempDate.withHour(10).withMinute(0);
        else if (tempDate.getHour() >= 18)
            tempDate = tempDate.plusDays(1).withHour(10).withMinute(0);

        while (hoursLeft > 0) {
            if (tempDate.getDayOfWeek().getValue() > 5)
                tempDate = tempDate.plusDays(1).withHour(10).withMinute(0);
            else {
                if ((tempDate.getHour() < 17) || (tempDate.getHour() == 17 && tempDate.getMinute() == 0))
                    tempDate = tempDate.plusHours(1);
                else if (tempDate.getDayOfWeek().getValue() == 5)
                    tempDate = tempDate.plusHours(17 + 48);
                else
                    tempDate = tempDate.plusHours(17);
                hoursLeft -= 1;
            }
        }
        return tempDate;
    }
}