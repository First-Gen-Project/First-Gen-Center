package bo;

public class Student {
    private int sId;
    private String sName;
    private String sAddress;
    private int chId;
    private int stfId;

    public Student(int sId, String sName, String sAddress, int chId, int stfId) {
        this.sId = sId;
        this.sName = sName;
        this.sAddress = sAddress;
        this.chId = chId;
        this.stfId = stfId;
    }
    public Student(int sId2, String sName2, String major, String minor, double gPA, int mtrId) {
        //TODO Auto-generated constructor stub
    }
    public Vector<Object> getRow(){
        Vector<Object> ret = new Vector();
        ret.add(this.sId);
        ret.add(this.sName);
        ret.add(this.sAddress);
        ret.add(this.chId);
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

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public int getChId() {
        return chId;
    }

    public void setChId(int chId) {
        this.chId = chId;
    }

    public int getStfId() {
        return stfId;
    }

    public void setStfId(int stfId) {
        this.stfId = stfId;
    }
}

