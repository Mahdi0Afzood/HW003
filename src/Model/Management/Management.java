package Model.Management;

import Model.List.CourseList;
import Model.List.GradeList;
import Model.List.ProfessorList;
import Model.List.StaffList;


public interface Management {
     StaffList PERSONLIST = new StaffList();
     CourseList courselist = new CourseList();
     ProfessorList professorList = new ProfessorList();
     GradeList gradeList = new GradeList();



   //  public PersonList getPersonList();




}
