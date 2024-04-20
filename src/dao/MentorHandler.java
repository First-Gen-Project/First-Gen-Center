package dao;

import bo.Mentor;
import utils.PasswordEncrypter;
import utils.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MentorHandler {
    private SQLUtil sqlUtil;

    public MentorHandler() {
        this.sqlUtil = new SQLUtil();
    }

    public Mentor login(String username, String password) {
        Mentor mentor = null;
        String encryptedPassword = PasswordEncrypter.encryptPassword(password);
        String stm = String.format("SELECT * FROM Mentor WHERE mtrUsername='%s' AND mtrPassword='%s'", username, encryptedPassword);
        ResultSet rsMentor = sqlUtil.executeQuery(stm);

        try {
            if (rsMentor != null && rsMentor.next()) {
                int mtrId = rsMentor.getInt("mtrId");
                String mtrName = rsMentor.getString("mtrName");
                mentor = new Mentor(mtrId, mtrName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mentor;
    }

    public boolean addMentor(String username, String password, String name) {
        String encryptedPassword = PasswordEncrypter.encryptPassword(password);
        String stm = String.format("INSERT INTO Mentor (mtrUsername, mtrPassword, mtrName) VALUES ('%s', '%s', '%s')", username, encryptedPassword, name);
        return sqlUtil.executeUpdate(stm) > 0;
    }

    public boolean deleteMentor(int mtrId) {
        String stm = String.format("DELETE FROM Mentor WHERE mtrId=%d", mtrId);
        return sqlUtil.executeUpdate(stm) > 0;
    }

    public boolean updateMentor(int mtrId, String username, String password, String name) {
        String encryptedPassword = PasswordEncrypter.encryptPassword(password);
        String stm = String.format("UPDATE Mentor SET mtrUsername='%s', mtrPassword='%s', mtrName='%s' WHERE mtrId=%d", username, encryptedPassword, name, mtrId);
        return sqlUtil.executeUpdate(stm) > 0;
    }
}
