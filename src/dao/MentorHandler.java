package dao;

import utils.SQLUtil;
import bo.Mentor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MentorHandler {
    private SQLUtil sqlUtil;

    public MentorHandler() {
        this.sqlUtil = new SQLUtil();
    }

    public Mentor login(String username, String password) {
        Mentor mentor = null;
        password = PasswordEncrypter.encryptPassword(password);
        String stm = String.format("SELECT * from mentor JOIN person WHERE username='%s' AND password='%s'", username, password);
        ResultSet rsMentor = sqlUtil.executeQuery(stm);

        try {
            if (rsMentor != null && rsMentor.next()) {
                int mtrId = rsMentor.getInt("samId");
                String mtrName = rsMentor.getString("name");
                String date_of_birth=rsMentor.getString("date_of_birth");
                mentor = new Mentor(mtrId, mtrName, username, password, date_of_birth);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mentor;
    }
    public boolean addMentor(String username, String password, String name, String dob) {
        String encryptedPassword = PasswordEncrypter.encryptPassword(password);
        String stm = String.format("INSERT INTO Mentor (mtrUsername, mtrPassword, mtrName) VALUES ('%s', '%s', '%s')", username, encryptedPassword, name);
        return sqlUtil.executeUpdate(stm) > 0;
    }
    public boolean deleteMentor(int mtrId) {
        String stm = String.format("DELETE FROM Mentor WHERE mtrId=%d", mtrId);
        return sqlUtil.executeUpdate(stm) > 0;
    }
    public boolean updateMentor(int mtrId, String username, String password, String name, String dob) {
        String encryptedPassword = PasswordEncrypter.encryptPassword(password);
        String stm = String.format("UPDATE Mentor SET mtrUsername='%s', mtrPassword='%s', mtrName='%s' WHERE mtrId=%d", username, encryptedPassword, name, mtrId);
        return sqlUtil.executeUpdate(stm) > 0;
    }
}
