package View;

import Model.Grade;
import Model.Course;
import Management.Login;
import Management.Management;
import Model.Clerk;
import Model.Professor;
import Model.Student;

import java.util.Scanner;

public class UniversityUi {
    Scanner input = new Scanner(System.in);
    Clerk clerk = new Clerk();
    Student student = new Student();
    Professor professor = new Professor();
    Course course = new Course();
    Grade grade = new Grade();
    Login login = new Login();

    public static void main(String[] args) {
        firstPanel();
    }

    public static void firstPanel() {
        while (true) {
            UniversityUi universityUi = new UniversityUi();
            System.out.println("Please select your panel and enter your username & password consequently\n" +
                    "1- clerk login  \n" +
                    "2- student login  \n" +
                    "3- professor login \n" +
                    "4- exit");
            String[] inputUPN = universityUi.input.nextLine().trim().split(" ");
            if (inputUPN.length != 3) {
                System.out.println("*********Please enter data carefully*********");
                firstPanel();
            }
            if (inputUPN[0].equals("1")) {
                if (universityUi.login.checkLogin(inputUPN[1], inputUPN[2], 1)) clerkPanel();
                else System.out.println("your user and password are incorrect please try again");

            } else if (inputUPN[0].equals("2")) {
                if (universityUi.login.checkLogin(inputUPN[1], inputUPN[2], 2)) studentPanel(inputUPN[1], inputUPN[2]);
                else System.out.println("your user and password are incorrect please try again");

            } else if (inputUPN[0].equals("3")) {
                if (universityUi.login.checkLogin(inputUPN[1], inputUPN[2], 3))
                    professorPanel(inputUPN[1], inputUPN[2]);
                else System.out.println("your user and password are incorrect please try again");
            } else if (inputUPN[0].equals("4")) break;

            else System.out.println("your number is out range . please retry .");
        }


    }

    public static void clerkPanel() {
        System.out.println("*****welcome to clerk panel*****");
        while (true) {
            UniversityUi universityUi = new UniversityUi();
            System.out.println("Please write add or delete or change and then enter one of numbers consequently \n" +
                    "1-Student \n" +
                    "2-Clerk \n" +
                    "3-Professor\n" +
                    "4-Course\n" +
                    "5-Show your salary\n" +
                    "6-Exit");
            String[] inputAll = universityUi.input.nextLine().trim().split(" ");
            // add student / clerk / professor / course
            if (inputAll[0].equals("add")) {
                if (inputAll[1].equals("1")) {
                    System.out.println("Please enter student first name , last name ,nationalCode, age, username, password");
                    String[] inputAllStudentInfo = universityUi.input.nextLine().trim().split(" ");
                    System.out.println(universityUi.clerk.registerStudentClerk(2, inputAllStudentInfo[0], inputAllStudentInfo[1], inputAllStudentInfo[2],
                            Integer.parseInt(inputAllStudentInfo[3]), inputAllStudentInfo[4], inputAllStudentInfo[5]));
                } else if (inputAll[1].equals("2")) {
                    System.out.println("Please enter clerk first name , last name ,nationalCode, age, username, password");
                    String[] inputAllStudentInfo = universityUi.input.nextLine().trim().split(" ");
                    System.out.println(universityUi.clerk.registerStudentClerk(1, inputAllStudentInfo[0], inputAllStudentInfo[1], inputAllStudentInfo[2],
                            Integer.parseInt(inputAllStudentInfo[3]), inputAllStudentInfo[4], inputAllStudentInfo[5]));
                } else if (inputAll[1].equals("3")) {
                    System.out.println("Please enter professor first name , last name ,nationalCode, age, username, password");
                    String[] inputAllStudentInfo = universityUi.input.nextLine().trim().split(" ");
                    System.out.println("if professor is ordinary enter number 1 if professor is primary enter number 2");
                    int input = universityUi.input.nextInt();
                    String professorType = "ordinary"; // default
                    if (input == 1) {
                        professorType = "ordinary";
                    } else if (input == 2) {
                        professorType = "primary";
                    }
                    System.out.println(universityUi.clerk.registerProfessor(3, inputAllStudentInfo[0], inputAllStudentInfo[1], inputAllStudentInfo[2],
                            Integer.parseInt(inputAllStudentInfo[3]), inputAllStudentInfo[4], inputAllStudentInfo[5], professorType));
                } else if (inputAll[1].equals("4")) {
                    System.out.println("Please enter courseName, courseUnit, professor national code : ");
                    String[] inputAllCourseInfo = universityUi.input.nextLine().trim().split(" ");
                    if (Management.PERSONLIST.containsNC(inputAllCourseInfo[2])) {
                        universityUi.clerk.addCourse(inputAllCourseInfo[0], inputAllCourseInfo[1], inputAllCourseInfo[2]);
                        System.out.println("the course set successfully.");
                    } else System.out.println("the national code hasn't exist.");
                } else System.out.println("you command can not execute cause of wrong entrance");
            }
            // delete student / clerk / professor / course
            else if (inputAll[0].equals("delete")) {
                //delete staffs
                if (inputAll[1].equals("1") || inputAll[1].equals("2") || inputAll[1].equals("3")) {
                    System.out.println("To delete staff , please enter student national code : ");
                    universityUi.clerk.deleteStaff(universityUi.input.next());
                }// delete course
                else if (inputAll[1].equals("4")) {
                    System.out.println("To delete course , please enter course id : ");
                    universityUi.clerk.deleteCourse(universityUi.input.nextInt());
                }
            }
            // change student / clerk / professor / course
            else if (inputAll[0].equals("change")) {
                System.out.println("Please enter national code of person OR " +
                        " course id , you want to modify ");
                String general = universityUi.input.next();
                String nationalCode = general;
                int courseId = Integer.parseInt(general);
                if (inputAll[1].equals("1")) {
                    Management.PERSONLIST.showInfo(nationalCode);
                    System.out.println("Please enter new info , Model.Student first name , last name ,nationalCode, age, username, password");
                    String[] inputAllStudentInfo = universityUi.input.nextLine().trim().split(" ");
                    Student student = new Student(2, inputAllStudentInfo[0], inputAllStudentInfo[1], inputAllStudentInfo[2],
                            Integer.parseInt(inputAllStudentInfo[3]), inputAllStudentInfo[4], inputAllStudentInfo[5]);
                    universityUi.clerk.changeStaffInfo(nationalCode, student);
                } else if (inputAll[1].equals("2")) {
                    Management.PERSONLIST.showInfo(nationalCode);
                    System.out.println("Please enter clerk first name , last name ,nationalCode, age, username, password");
                    String[] inputAllStudentInfo = universityUi.input.nextLine().trim().split(" ");
                    Clerk clerk = new Clerk(1, inputAllStudentInfo[0], inputAllStudentInfo[1], inputAllStudentInfo[2],
                            Integer.parseInt(inputAllStudentInfo[3]), inputAllStudentInfo[4], inputAllStudentInfo[5]);
                    universityUi.clerk.changeStaffInfo(nationalCode, clerk);
                } else if (inputAll[1].equals("3")) {
                    Management.PERSONLIST.showInfo(nationalCode);
                    System.out.println("Please enter new info , professor first name , last name ,nationalCode, age, username, password"
                            + " if professor is ordinary enter number 1 if professor is primary enter number 2");
                    String[] inputAllProf = universityUi.input.nextLine().trim().split(" ");
                    String professorType = "ordinary"; // default
                    if (inputAllProf[6].equals("1")) professorType = "ordinary";
                    else if (inputAllProf[6].equals("2")) professorType = "primary";
                    Professor professor = new Professor(3, inputAllProf[0], inputAllProf[1], inputAllProf[2],
                            Integer.parseInt(inputAllProf[3]), inputAllProf[4], inputAllProf[5]);
                    universityUi.clerk.changeProfessorInfo(nationalCode, professor, inputAllProf[6]);
                } else if (inputAll[1].equals("4")) {
                    Management.courselist.showInfo(courseId);
                    System.out.println("Please enter courseName, courseUnit, professor national code : ");
                    String[] inputAllCourseInfo = universityUi.input.nextLine().trim().split(" ");
                    if (Management.PERSONLIST.containsNC(inputAllCourseInfo[2])) {
                        Course course = new Course(inputAllCourseInfo[0], inputAllCourseInfo[1], inputAllCourseInfo[2]);
                        universityUi.clerk.changeCourse(courseId, course);
                    }
                }
            } else if (inputAll[0].equals("5")) universityUi.clerk.showSalary();
            else if (inputAll[0].equals("6")) break;
            else System.out.println("your command is out of range.Please retry.");
        }
    }

    public static void studentPanel(String username, String password) {
        System.out.println("*****welcome to student panel*****");
        while (true) {
            UniversityUi universityUi = new UniversityUi();
            System.out.println("Please enter one of numbers of selection \n" +
                    "1- Show my information \n" +
                    "2- Show list of courses \n" +
                    "3- Select courses \n" +
                    "4- Show my courses & grades\n" +
                    "5- Exit");
            String inputNumber = universityUi.input.next();
            if (inputNumber.equals("1")) universityUi.student.showMyInfo(username, password, 2);
            else if (inputNumber.equals("2")) universityUi.course.showAllList();
            else if (inputNumber.equals("3")) {
                try{
                    System.out.println("Please enter your desired course ID :");
                    int courseID = universityUi.input.nextInt();
                    String nationalCode = universityUi.student.findNationalCode(username,password);
                    universityUi.grade.getCourse(courseID,nationalCode);
                    System.out.println("You select course successfully");
                }catch (Exception e){
                    System.out.println(e);
                    System.out.println("You can't select that course");}
            } else if (inputNumber.equals("4")){
                try {
                    String nationalCode = universityUi.student.findNationalCode(username,password);
                    universityUi.grade.showMyCourse(nationalCode);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
            else if (inputNumber.equals("5")) break;
        }
    }

    public static void professorPanel(String username, String password) {
        System.out.println("*****welcome to professor panel*****");
        while (true) {
            UniversityUi universityUi = new UniversityUi();
            System.out.println("Please select one of the numbers \n" +
                    "1- show my information \n" +
                    "2- Enter & Set students grade\n" +
                    "3- Show salary of specific semester \n" +
                    "4- Exit");
            String inputAll = universityUi.input.next();
            if (inputAll.equals("1")) universityUi.professor.showMyInfo(username, password, 3);
            else if (inputAll.equals("2")) {
               //todo
                /* String nationalCodeProfessor = Management.PERSONLIST.get(username,password,3).getNationalCode();
                if (Management.courselist.contains(nationalCodeProfessor)){
                    Course[] course = Management.courselist.getCourses(nationalCodeProfessor);
                    for (int i=0;i<course.length;i++){

                    }
                }*/
                System.out.println("Please enter student national code & course id in two lines : ");
                String NationalCode = universityUi.input.next();
                int courseId = universityUi.input.nextInt();
                System.out.println("Please enter grade");
                Management.courselist.get(courseId).setGrade(universityUi.input.nextInt());
                System.out.println("the grade entered successfully");
            }
            else if (inputAll.equals("3")) {
                try{
                    System.out.println("Please enter the year you teaching :");
                    int year = universityUi.input.nextInt();
                    universityUi.professor.showSalary(username, password, year);
                }catch(Exception e){
                    System.out.println("The professor not yet teaching .");
                }
            } else if (inputAll.equals("4")) break;
        }
    }
}
