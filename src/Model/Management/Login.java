package Model.Management;

import Model.List.StaffList;

public class Login implements Management {

    public StaffList getPersonList() {
        return Management.PERSONLIST;
    }

    public boolean checkLogin(String username ,String password , int id){
        return getPersonList().containsUP(username,password,id);
    }

}
