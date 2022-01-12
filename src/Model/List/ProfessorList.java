package Model.List;

import Model.Management.Management;
import Model.Staff.Staff;

import java.util.ArrayList;

public class ProfessorList extends StaffList{
    private ArrayList<String> professorType = new ArrayList<>();
    private ArrayList<Integer> indexProfessor = new ArrayList<Integer>();
    private ArrayList<Integer> NumberOfCourse = new ArrayList<Integer>();

    public void setNumberOfCourse(int numberOfCourse) {
        NumberOfCourse.add(numberOfCourse);
    }

    public int getNumberOfCourse(int index) {
        return NumberOfCourse.get(index);
    }

    public int findCorrespondingIndex(String professorNC){
        int value = Management.PERSONLIST.getIndex(professorNC);
        return Management.professorList.getIndexProfessor(value);
    }


    public void modifyPerson(String nationalCode, Staff value,String professorType) {
        super.modifyPerson(nationalCode,value);
        this.professorType.set(findCorrespondingIndex(nationalCode),professorType);
    }


    public void addPerson(Staff value,String professorType) {
        super.addPerson(value);
        addType(professorType);
        getIndex();
    }

    public String getProfessorType(int index){
        return professorType.get(index);
    }

    public void addType(String professorType){
        this.professorType.add(professorType);
    }

    public int getIndexProfessor(int index){
        return indexProfessor.indexOf(index);
    }

    public void setProfessorType(ArrayList<String> professorType) {
        this.professorType = professorType;
    }

    private void getIndex(){
        indexProfessor.add(getIndex(3));
    }
}
