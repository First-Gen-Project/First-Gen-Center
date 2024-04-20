package bo;

public class Mentor {
    private int mtrId;
    private String mtrName;

    public Mentor(int mtrId, String mtrName) {
        this.mtrId = mtrId;
        this.mtrName = mtrName;
    }

    public int getMtrId() {
        return mtrId;
    }

    public void setMtrId(int mtrId) {
        this.mtrId = mtrId;
    }

    public String getMtrName() {
        return mtrName;
    }

    public void setMtrName(String mtrName) {
        this.mtrName = mtrName;
    }
    
}
