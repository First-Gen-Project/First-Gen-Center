package bo;


public class Mentor {
    private int mtrId;
    private String mtrName;
    private String username;
    private String password;

    public Mentor(int mtrId, String mtrName, String username, String password) {
        this.mtrId=mtrId;
        this.mtrName=mtrName;
        this.username=username;
        this.password=password;
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
    
}
