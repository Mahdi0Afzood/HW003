package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Semester {
    private ArrayList<Integer> years = new ArrayList<Integer>();
    private static int currentYear =  LocalDate.now().getYear();
    private static Term term ;


    public ArrayList<Integer> getYears() {
        return years;
    }

    public void setYears(ArrayList<Integer> years) {
        this.years = years;
    }

    public static int getCurrentYear() {
        return currentYear;
    }

    public static void setCurrentYear(int currentYear) {
        Semester.currentYear = currentYear;
    }

    public static String getTerm() {
        return term.toString();
    }

    public static void setTerm(Term term) {
        Semester.term = term;
    }

    {
        //default
        term = term.Term1;
    }

}
