package Model;

import Management.Management;

public class Course implements Management {
    private int courseId ;
    private String courseName;
    private String courseUnit;
    private String nationalCodeProfessor;
    private int grade;
    private static Semester semester = new Semester();


    public static Semester getSemester() {
        return semester;
    }

    public static void setSemester(Semester semester) {
        Course.semester = semester;
    }

    public Course(){}

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Course(String courseName, String courseUnit, String nationalCode) {
        this.courseName = courseName;
        this.courseUnit = courseUnit;
        this.nationalCodeProfessor = Management.PERSONLIST.get(nationalCode).getNationalCode();
    }

    public Course findCourseId(int courseId){
        return Management.courselist.get(courseId);
    }

    public String showProfessorName(String nationalCodeProfessor){
       return Management.PERSONLIST.get(nationalCodeProfessor).getFirstName() + "  " +
                Management.PERSONLIST.get(nationalCodeProfessor).getLastName();
    }

    public String getNationalCodeProfessor() {
        return nationalCodeProfessor;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getGrade() {
        return grade;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseUnit() {
        return courseUnit;
    }

    public void showAllList(){
        Management.courselist.showAll(Semester.getCurrentYear(),Semester.getTerm());
    }

    public void setCourseUnit(String courseUnit) {
        this.courseUnit = courseUnit;
    }
}
