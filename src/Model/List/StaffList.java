package Model.List;

import Model.Staff.Professor;
import Model.Staff.Staff;
import Model.Staff.Student;

import java.util.Arrays;

public class StaffList {
    private Staff[] staff = {};

    public void addPerson(Staff value) {
        Staff[] temp = new Staff[size() + 1];
        for (int i = 0; i < size(); i++) {
            temp[i] = staff[i];
        }
        temp[temp.length - 1] = value;
        staff = temp;
    }

    public void modifyPerson(String nationalCode, Staff value) {
        if (containsNC(nationalCode)) {
            staff[getIndex(nationalCode)] = value;
        } else System.out.println("national code you entered , was wrong.");
    }

    // contains
    public boolean containsNC(String nationalCode) {
        if (get(nationalCode) != null) return true;
        else return false;
    }

    public boolean containsUP(String username, String password, int id) {
        for (int i = 0; i < size(); i++) {
            if (staff[i].getUserName().equals(username) && staff[i].getPassword().equals(password) && staff[i].getId() == id)
                return true;
        }
        return false;
    }

    public void remove(int index) {
        if (isInvalidIndex(index)) {
            System.out.println("out of bounds");
            return;
        }
        Staff[] temp = new Staff[size() - 1];
        for (int i = 0; i < size(); i++) {
            if (i < index)
                temp[i] = staff[i];
            if (i > index)
                temp[i - 1] = staff[i];
        }
        staff = temp;
    }

    public int getIndex(int id) {
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getId() == id)
                return i;
        }
        return -1;
    }

    public int getIndex(String nationalCode) {
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getNationalCode().equals(nationalCode))
                return i;
        }
        return -1;
    }

    public Staff get(String nationalCode) {
        Staff staff = null;
        for (int i = 0; i < this.staff.length; i++) {
            if (this.staff[i].getNationalCode().equals(nationalCode)) {
                staff = this.staff[i];
            }
        }
        return staff;
    }

    public Student getStudent(String username, String password) {
        Student Student = null;
        for (int i = 0; i < this.staff.length; i++) {
            if (this.staff[i].getUserName().equals(username)&& this.staff[i].getPassword().equals(password)&&
                    this.staff[i].getId()==2) {
                Student = (Student) this.staff[i];
            }
        }
        return Student;
    }

    public Staff get(String username, String password , int id) {
        Staff staff = null;
        for (int i = 0; i < this.staff.length; i++) {
            if (this.staff[i].getUserName().equals(username)&& this.staff[i].getPassword().equals(password)&&
            this.staff[i].getId()==id) {
                staff = this.staff[i];
            }
        }
        return staff;
    }

    public Staff[] getArray() {
        return staff;
    }

    public int size() {
        return staff.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private boolean isInvalidIndex(int index) {
        return index < 0 || index >= size();
    }

    public void showAll() {
        for (int i = 0; i < staff.length; i++) System.out.println(staff[i].getFirstName());
    }

    public String showInfo(String username, String password, int id) {
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getUserName().equals(username) && staff[i].getPassword().equals(password) && staff[i].getId() == id) {
                return "*\nfirst name : " + staff[i].getFirstName() + "\nlast name : " + staff[i].getLastName() + "\nnational code : "
                        + staff[i].getNationalCode() + "\n*";
            }
        }
        return "there is no info";
    }

    public String showInfo(String nationalCode) {
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getNationalCode().equals(nationalCode)) {
                return "*\nfirst name : " + staff[i].getFirstName() + "\nlast name : " + staff[i].getLastName() + "\nnational code : "
                        + staff[i].getNationalCode() + "\n*";
            }
        }
        return "there is no info";
    }


    @Override
    public String toString() {
        return "PersonList{" +
                "persons=" + Arrays.toString(staff) +
                '}';
    }
}

