package repository.List;

import Model.Staff;
import Model.Course;
import Model.Grade;

import java.util.ArrayList;

public class GradeList {
    ArrayList<Grade> grades = new ArrayList<>();

    public void addGrade(Grade grade){
        grades.add(grade);
    }

    public void getMyCourseInfo(Staff student){
        for (int index=0;index<grades.size();index++){
            if (grades.get(index).getStudent() == student) {
                Course course = grades.get(index).getCourse();
                System.out.println("Course : "+course.getCourseName()+
                      /*  "\nProfessor : "+course.
                        showProfessorName(course.getNationalCodeProfessor())+*/
                        "\nYear : "+course.getSemester().getCurrentYear()+
                        "\nTerm : "+course.getSemester().getTerm()+
                        "\nGrade : "+grades.get(index).getGrade());
            }
        }

    }


}
