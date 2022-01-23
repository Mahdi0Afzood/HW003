package Management;

import repository.List.CourseList;
import repository.List.GradeList;
import repository.List.ProfessorList;
import repository.List.StaffList;


public interface Management {
     StaffList PERSONLIST = new StaffList();
     CourseList courselist = new CourseList();
     ProfessorList professorList = new ProfessorList();
     GradeList gradeList = new GradeList();



   //  public PersonList getPersonList();




}
