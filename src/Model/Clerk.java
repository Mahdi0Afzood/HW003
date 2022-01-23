package Model;

import Management.Management;

public class Clerk extends Staff implements Management {
    private final double salary = 1200000;
    private Student student = new Student();


    public Clerk(int id, String firstName, String lastName, String nationalCode, int age, String userName, String password) {
        super(id, firstName, lastName, nationalCode, age, userName, password);
    }

    public Clerk() {
        registerStudentClerk(1, "clerk1", "clerk1", "202244", 45, "admin", "admin");
    }

    // add staff & courses
    //TODO national code must be unique.
    public String registerStudentClerk(int id, String firstName, String lastName, String nationalCode,
                                       int age, String username, String password) {
        Staff staff = new Staff(id, firstName, lastName, nationalCode, age, username, password);
        Management.PERSONLIST.addPerson(staff);
        return "*\nid : " + id + "\nusername : " + username + "\npassword : " + password + "\n*";
    }

    public String registerProfessor(int id, String firstName, String lastName, String nationalCode,
                                    int age, String username, String password, String professorType) {
        Staff staff = new Staff(id, firstName, lastName, nationalCode, age, username, password);
        Management.PERSONLIST.addPerson(staff);
        Management.professorList.addPerson(staff,professorType);
        return "*\nid : " + id + "\nusername : " + username + "\npassword : " + password + "\n*";
    }

    //TODO course name in year of term and term number must be unique.
    public void addCourse(String courseName, String courseUnit,String nationalCode) {
        Course course = new Course(courseName, courseUnit, nationalCode);
        Management.courselist.addCourse(course);
    }


    // delete staff & course
    public void deleteStaff(String nationalCode) {
        if (Management.PERSONLIST.containsNC(nationalCode)) {
            System.out.println("*\nMr/MS : " +
                    Management.PERSONLIST.get(nationalCode).getFirstName() +
                    " " + Management.PERSONLIST.get(nationalCode).getLastName() + " has deleted." +
                    "\n*");
            Management.PERSONLIST.remove(Management.PERSONLIST.getIndex(nationalCode));
        } else System.out.println("this national code doesn't exist .");
    }

    public void deleteCourse(int courseId){
        if (Management.courselist.contains(courseId)){
            System.out.println(Management.courselist.get(courseId).getCourseName() +
                    " has deleted." +
                    "\n*");
            Management.PERSONLIST.remove(Management.PERSONLIST.getIndex(courseId));
            //student.removeCourse(courseId);
        }
    }

    // change student info & course
    public void changeStaffInfo(String nationalCode, Staff staff) {
        Management.PERSONLIST.modifyPerson(nationalCode, staff);
    }
    public void changeProfessorInfo(String nationalCode, Staff staff,String professorType) {
        Management.PERSONLIST.modifyPerson(nationalCode, staff);
    }





    public void changeCourse(int courseId, Course course){
        Management.courselist.modifyCourse(courseId,course);
    }



    public void showSalary() {
        System.out.println("Your salary is " + salary + " per month");
    }


}