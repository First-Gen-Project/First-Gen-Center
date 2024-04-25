package bo;


public class Mentor {
    private int mtrId;
    private String mtrName;
    private String username;
    private String password;
    private String dob;

    public Mentor(int mtrId, String mtrName, String username, String password, String dob) {
        this.mtrId=mtrId;
        this.mtrName=mtrName;
        this.username=username;
        this.password=password;
        this.dob=dob;
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

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }
    
    public String getDob(){
        return dob;
    }

    public void setDob(String dob){
        this.dob=dob;
    }
}
