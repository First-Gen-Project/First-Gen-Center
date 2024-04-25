package bo;

import java.util.Vector;
import dao.StudentHandler;

public class Student{
    private int samID;
    private String name;
    private String email;
    private String date_of_birth;
    private String Major;
    private String Minor;
    private double GPA;
    private int mtrID;
    private String dob;

    public Student(int samID, String name, String email, String date_of_birth, String Major, String Minor, double GPA, int mtrID) {
        this.samID = samID;
        this.name = name;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.Major = Major;
        this.Minor = Minor;
        this.GPA = GPA;
        this.mtrID = mtrID;
    }
    public Vector<Object> getRow(){
        Vector<Object> ret = new Vector<>();
        ret.add(this.samID);
        ret.add(this.name);
        ret.add(this.email);
        ret.add(this.date_of_birth);
        ret.add(this.Major);
        ret.add(this.Minor);
        ret.add(this.GPA);
        ret.add(this.mtrID);
        return ret;
    }
   
    
    public int getsamID() {
        return samID;
    }

    public void setsamID(int samID) {
        this.samID = samID;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getemail(){
        return email;
    }
    
    public void setemail(String email){
        this.email = email;
    }
    public String getdate_of_birth(){
        return date_of_birth;
    }
    
    public void setdate_of_birth(String date_of_birth){
        this.email = date_of_birth;
    }
    
    public String getsMajor() {
        return Major;
    }

    public void setsMajor(String Major) {
        this.Major = Major;
    }

    public void setsMinor(String Minor) {
        this.Minor = Minor;
    }
    public String getsMinor() {
        return Minor;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

    public int getMtrId() {
        return mtrID;
    }

    public void setMtrId(int mtrID) {
        this.mtrID = mtrID;
    }


}

