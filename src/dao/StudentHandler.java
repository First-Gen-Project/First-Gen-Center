package dao;

import bo.Mentor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.logging.Level;
import java.util.logging.Logger;
import util.SQLUtil;

public class StudentHandler {
    
    private SQLUtil sqlUtil;

    public StudentHandler(){
        sqlUtil=new SQLUtil();
    }

    public int addStudent(String sName, String Major, String Minor, double GPA, int mtrId){
        String cmdTemplate="insert into Student (sName, Major, Minor, GPA ex.0.00, mtrId) values (%s, %s, %s,%d, %d)";
        String stmStr=String.format(cmdTemplate, sName, Major, Minor, GPA, mtrId);
        return sqlUtil.executeUpdate(stmStr);
    }

    public int deleteStudent(int sId){
        String stm=String.format("delete from student sId=%d", sId);
        return sqlUtil.executeUpdate(stm);
    }

    public int updateStudent(String sName, String Major, String Minor, double GPA, int mtrId){
        String cmdTemplate = "update Student set sName='%s', Major='%s', Minor='%s' GPA='%d', mtrId='%d'";
        String stmStr=String.format(cmdTemplate, sName, Major, Minor, GPA, mtrId);
        return sqlUtil.executeUpdate(stmStr);
    }

    public List<Student> getStudents(String keyword){
        String stmStr=String.format("select all from Student where sName is like '%s'", "%"+keyword+"%");
        List<Student> students= new ArrayList<>();
        ResultSet rs=sqlUtil.executeQuery(stmStr);
        try{
            while(rs.next()){
                int sId=rs.getInt("sId");
                String sName=rs.getString("sName");
                String Major=rs.getString("Major");
                String Minor=rs.getString("Minor");
                double GPA=rs.getDouble("GPA");
                int mtrId=rs.getInt("mtrName");
                Student s = new Student(sId, sName, Major, Minor, GPA, mtrId);
                students.add(s);
            }
        } catch (SQLException ex){
            Logger.getLogger(StudentHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

}
