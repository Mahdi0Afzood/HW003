package Model.Staff;

import Model.Management.Management;
import Model.Staff.Staff;

import javax.swing.*;


public class Professor extends Staff implements Management {
    //private String ProfessorType ;//ordinary primary


    //todo
    public void setStudentGrades() {

    }

    public Professor(int id, String firstName, String lastName, String nationalCode, int age, String userName, String password) {
        super(id, firstName, lastName, nationalCode, age, userName, password);
    }

    public Professor() {
    }

    public void showMyInfo(String username, String password, int id) {
        System.out.println(Management.PERSONLIST.showInfo(username, password, id));
    }


    public int showSalary(String username, String password, int year) {
        String professorNC = Management.PERSONLIST.get(username, password, 3).getNationalCode();
        int correspondingValue = Management.professorList.findCorrespondingIndex(professorNC);
        String professorType = Management.professorList.getProfessorType(correspondingValue);
        if (professorType.equals("ordinary")) {
            return Management.professorList.getNumberOfCourse(correspondingValue) * 1000000;
        }
        else if (professorType.equals("primary")) {
            return Management.professorList.getNumberOfCourse(correspondingValue) * 1000000 + 5000000;
        }
        return 0;
    }
}
