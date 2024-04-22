package bo;

import java.util.Vector;

public class Student {
    private int samID;
    private String name;
    private String email;
    private String Major;
    private String Minor;
    private double GPA;
    private int mtrId;
    private String dob;

    public Student(int samID, String name, String Major, String Minor, double GPA, int mtrId, String dob) {
        this.samID = samID;
        this.name = name;
        this.Major = Major;
        this.Minor = Minor;
        this.GPA = GPA;
        this.mtrId = mtrId;
    }
    public Vector<Object> getRows(){
        Vector<Object> ret = new Vector<>();
        ret.add(this.samID);
        ret.add(this.name);
        ret.add(this.email);
        ret.add(this.Major);
        ret.add(this.Minor);
        ret.add(this.GPA);
        ret.add(this.mtrId);
        return ret;
    }
    public Vector getRow(){
        Vector vec = new Vector<>();
        vec.add(this.samID);
        vec.add(this.name);
        vec.add(this.email);
        vec.add(this.Major);
        vec.add(this.Minor);
        vec.add(this.GPA);
        vec.add(this.mtrId);
        return vec;
    }
    public int getsamID() {
        return samID;
    }

    public void setsamID(int samID) {
        this.samID = samID;
    }

    public String getname() {
        return name;
    }
    
    public void setname(String name) {
        this.name = name;
    }

    public String getemail(){
        return email;
    }
    
    public void setemail(String email){
        this.email = email;
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
        return mtrId;
    }

    public void setMtrId(int mtrId) {
        this.mtrId = mtrId;
    }

    public void setsDob(String dob) {
        this.dob = dob;
    }

    public String getsDob() {
        return dob;
    }
}

