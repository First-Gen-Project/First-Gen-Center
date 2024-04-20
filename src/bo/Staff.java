package bo;

public class Staff {
    private int stfId;
    private String stfName;

    public Staff(int stfId, String stfName) {
        this.stfId = stfId;
        this.stfName = stfName;
    }

    public int getStfId() {
        return stfId;
    }

    public void setStfId(int stfId) {
        this.stfId = stfId;
    }

    public String getStfName() {
        return stfName;
    }

    public void setStfName(String stfName) {
        this.stfName = stfName;
    }
    
}
