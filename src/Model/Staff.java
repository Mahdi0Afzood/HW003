package Model;

import Management.Management;

public class Staff {
    private int id; // id 1 -> clerk / 2-> student / 3 -> professor
    private String firstName , lastName , nationalCode;
    private int age;
    private String userName,password;

    // constructor
    public Staff(int id, String firstName, String lastName, String nationalCode, int age , String userName , String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.age = age;
        this.userName = userName;
        this.password = password;
        this.id = id;
    }
    public Staff(){}

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public int getId() {
        return id;
    }

    public Staff findStudent(String nationalCode){
        return Management.PERSONLIST.get(nationalCode);
    }
}
