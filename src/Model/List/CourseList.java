package Model.List;

import Model.Term.Course;
import Model.Management.Management;

import java.util.ArrayList;
import java.util.Arrays;

public class CourseList {
    private Course[] courses  = {};

    public void addCourse(Course value) {
        Course[] temp = new Course[size() + 1];
        for (int i = 0; i < size(); i++) {
            temp[i] = courses[i];
        }
        temp[temp.length - 1] = value;
        courses = temp;
        increaseCourseID();
    }

    public void increaseCourseID(){
        int lastHome = courses.length - 1;
        int size = courses.length;
        courses[0].setCourseId(1);
        courses[lastHome].setCourseId(size * courses[0].getCourseId());
    }


    public void modifyCourse(int courseId, Course value) {
        if (contains(courseId)){
            courses[getIndex(courseId)] = value;
        }else System.out.println("course id you entered , was wrong.");
    }
    // contains
    public boolean contains(Course values) {
        for (int i = 0; i < size(); i++) {
            if (get(i).getCourseId() == values.getCourseId())
                return true;
        }
        return false;
    }

    public boolean contains(int CourseId) {
        if (get(CourseId) != null) return true;
        else return false;
    }

    public boolean contains(String professorNC) {
        if (get(professorNC) != null) return true;
        else return false;
    }

    public void remove(int index) {
        if (isInvalidIndex(index)) {
            System.out.println("out of bounds");
            return;
        }
        Course[] temp = new Course[size() - 1];
        for (int i = 0; i < size(); i++) {
            if (i < index)
                temp[i] = courses[i];
            if (i > index)
                temp[i - 1] = courses[i];
        }
        courses = temp;
    }

    public int getIndex(int courseId) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getCourseId()==courseId)
                return i;
        }
        return -1;
    }

    public Course get(int courseId) {
        Course course = null;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getCourseId() == courseId) {
                course = courses[i];
            }
        }
        return course;
    }

    public Course get(String professorNC) {
        Course course = null;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getNationalCodeProfessor().equals(professorNC)) {
                course = courses[i];
            }
        }
        return course;
    }
    public Course[] getCourses(String professorNC) {
        Course[] course = null;
        int j =0;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getNationalCodeProfessor().equals(professorNC)) {
                course[j] = courses[i];
                j++;
            }
        }
        return course;
    }




    public Course[] getArray() {
        return courses;
    }

    public int size() {
        return courses.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private boolean isInvalidIndex(int index) {
        return index < 0 || index >= size();
    }

    public void showAll(int yearOfTerm , String termNumber){
        for (int i = 0; i < courses.length; i++) System.out.println("*\ncourse id : "+courses[i].getCourseId()+
                "\ncourse name :"+courses[i].getCourseName()+"\ncourse unit :"+courses[i].getCourseUnit()+
                "\ncourse year of term : "+yearOfTerm+"\ncourse term number :"+termNumber+
                "\nprofessor name : "+ Management.PERSONLIST.get(courses[i].getNationalCodeProfessor()).getFirstName()+" "+
                Management.PERSONLIST.get(courses[i].getNationalCodeProfessor()).getLastName()+"\n");
    }

    public String showInfo(int courseId) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getCourseId()==(courseId)) {
                return "*\nfirst name : " + courses[i].getCourseName()+ "\ncourse id : "
                        + courses[i].getCourseId() + "\n*";
            }
        }
        return "there is no info";
    }

    @Override
    public String toString() {
        return "PersonList{" +
                "persons=" + Arrays.toString(courses) +
                '}';
    }


}
