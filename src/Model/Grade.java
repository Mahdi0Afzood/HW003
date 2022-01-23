package Model;

import Management.Management;

public class Grade implements Management {
    private static Course course ;
    private static Staff student ;
    private static int grade;

    public Grade(){
        this.course = new Course();
        this.student = new Student();
        this.grade = 0;
    }

    public static Course getCourse() {
        return course;
    }

    public static void setCourse(Course course) {
        Grade.course = course;
    }

    public static Staff getStudent() {
        return student;
    }

    public static void setStudent(Student student) {
        Grade.student = student;
    }

    public static int getGrade() {
        return grade;
    }

    public static void setGrade(int grade) {
        Grade.grade = grade;
    }

    public void getCourse(int courseID, String nationalCode){
        course = course.findCourseId(courseID);
        student = student.findStudent(nationalCode);
        addToList();
    }

    public void addToList(){
        Management.gradeList.addGrade(new Grade());
    }

    public void showMyCourse(String nationalCode){
        student = student.findStudent(nationalCode);
        Management.gradeList.getMyCourseInfo(student);
    }


}
