package dao;

import bo.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentHandler {
    
    private SQLUtil sqlUtil;

    public StudentHandler(){
        sqlUtil=new SQLUtil();
    }

    public int addStudent(int samID, String name, String email, String Major, String Minor, double gpa, int mtrId, String Dob) {
        String cmdTemplate = "insert into Student (samID, name, Major, Minor, GPA, mtrId) values (%s, %s, %s, %d, %d)";
        String cmd = String.format(cmdTemplate, name, Major, Minor, gpa, mtrId, Dob);
        try (PreparedStatement preparedStatement = sqlUtil.getConnection().prepareStatement(cmdTemplate)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, Major);
            preparedStatement.setString(3, Minor);
            preparedStatement.setDouble(4, gpa);
            preparedStatement.setInt(5, mtrId);
            preparedStatement.setString(6, Dob);
            return preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public List<Student> loadStudents(String keyword){
        
            List<Student> students = new ArrayList<>();
            String cmdTemplate = "select samID, name, email, Dob, Major, Minor, GPA, mtrId from Student where name like '%s'";
            String cmd = String.format(cmdTemplate, "%" + keyword + "%");
            ResultSet rs = sqlUtil.executeQuery(cmd);
        try {    
            while(rs.next()){
                int samID = rs.getInt("samID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String Major = rs.getString("Major");
                String Minor = rs.getString("Minor");
                double gpa = rs.getDouble("GPA");
                int mtrId = rs.getInt("mtrName");
                String Dob = rs.getString( "Dob");
                Student student = new Student(samID, name, Major, Minor, gpa, mtrId, Dob);
                students.add(student);
            }    
                        
          } catch (SQLException ex) {      
            Logger.getLogger(StudentHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
    public int deleteStudent(int samID){
        String stm=String.format("delete from student samID=%d", samID);
        return sqlUtil.executeUpdate(stm);
    }

    public int updateStudent(String name, String Major, String Minor, double gpa, int mtrId, String Dob){
        String cmdTemplate = "update Student set name='%s', Major='%s', Minor='%s' GPA='%d', mtrId='%d', Dob='%s'";
        String stmStr=String.format(cmdTemplate, name, Major, Minor, gpa, mtrId);
        return sqlUtil.executeUpdate(stmStr);
    }

    public List<Student> getStudents(String keyword){
        String stmStr=String.format("select all from Student where name is like '%s'", "%"+keyword+"%");
        List<Student> students= new ArrayList<>();
        ResultSet rs=sqlUtil.executeQuery(stmStr);
        try{
            while(rs.next()){
                int samID=rs.getInt("samID");
                String name=rs.getString("name");
                String email = rs.getString("email");
                String Major=rs.getString("Major");
                String Minor=rs.getString("Minor");
                double GPA=rs.getDouble("GPA");
                int mtrId=rs.getInt("mtrName");
                String Dob=rs.getString( "Dob");
                Student s = new Student(samID, name, Major, Minor, GPA, mtrId, Dob);
                students.add(s);
            }
        } catch (SQLException ex){
            Logger.getLogger(StudentHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

}
