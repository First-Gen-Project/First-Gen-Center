package dao;
import bo.Mentor;
import java.sql.ResultSet;
import utils.PasswordEncryptor;
import utils.SQLUtil;

public class MentorHandler {
    private SQLUtil sqlUtil;

    public MentorHandler(){
        this.sqlUtil = new SQLUtil();
    }

    public Mentor login(String username, String password){
        Mentor mtr = null;
        //encryption
        password = PasswordEncryptor.encryptPassword(password);
        String stm = String.format("select Mentor ID, Mentor Name from Mentor where mtrUsername='%s' and mtrPassword='%s'", username, password);
        ResultSet rsMentor=sqlUtil.executeQuery(stm);

        try{
            if(rsMentor!=null && rsMentor.next()){
                int mtrId=rsMentor.getInt("mtrId");
                String mtrName=rsMentor.getString("mtrName");
                mtr = new Mentor(mtrId, mtrName);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return mtr;
    }
}
