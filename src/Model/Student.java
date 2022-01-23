package Model;

import Management.Management;
import Management.Verification;

import java.util.ArrayList;

public class Student extends Staff implements Management {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> studentsTakeCourse = new ArrayList<>();
    private Verification verification = new Verification();

    public void chooseCourse(String username , String password ,int courseId){
        if (verification.isNull(Management.courselist.get(courseId))) System.out.println("your course has not exist.");
        else {
            if (!courses.contains(courseId)){
                courses.add(Management.courselist.get(courseId));
                getCourse(username,password);
                System.out.println("you choose course successfully");
            }
        }
    }

    private void getCourse(String username,String password){
        studentsTakeCourse.add(Management.PERSONLIST.getStudent(username,password));
    }

    public void showMyCourses(String username,String password){
        for (int i = 0 ; i<studentsTakeCourse.size();i++){
            if (studentsTakeCourse.get(i).getUserName().equals(username) &&
                    studentsTakeCourse.get(i).getPassword().equals(password)) {
                System.out.println("course name :" + courses.get(i).getCourseName() + "\ncourse unit :" + courses.get(i).getCourseUnit() + "\ngrade :"+
                        courses.get(i).getGrade()+"\n");
            }
        }
    }



    public String findNationalCode(String username ,String password){
       return Management.PERSONLIST.get(username,password,2).getNationalCode();
    }

    //todo
  /*  public void removeCourse(int courseID){
        Management.Management.courseStudents.remove(courseID);
    }*/



    public void showMyInfo(String username,String password ,int id){
        System.out.println(Management.PERSONLIST.showInfo(username,password,id));
    }


    public Student(int id, String firstName, String lastName, String nationalCode, int age, String userName, String password) {
        super(id, firstName, lastName, nationalCode, age, userName, password);
    }
    public Student(){}


}
