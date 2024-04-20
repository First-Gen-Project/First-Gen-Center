package bo;

import java.util.Vector;

public class Student {
    private int sId;
    private String sName;
    private String Major;
    private String Minor;
    private double GPA;
    private int mtrId;
    private String dob;

    public Student(int sId, String sName, String Major, String Minor, double GPA, int mtrId, String dob) {
        this.sId = sId;
        this.sName = sName;
        this.Major = Major;
        this.Minor = Minor;
        this.GPA = GPA;
        this.mtrId = mtrId;
    }
    public Vector<Object> getRow(){
        Vector<Object> ret = new Vector<>();
        ret.add(this.sId);
        ret.add(this.sName);
        ret.add(this.Major);
        ret.add(this.Minor);
        ret.add(this.GPA);
        ret.add(this.mtrId);
        return ret;
    }
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
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

