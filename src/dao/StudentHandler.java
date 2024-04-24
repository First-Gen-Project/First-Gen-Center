package dao;

import utils.SQLUtil;
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
        sqlUtil = new SQLUtil();
    }

    public int addStudent(int samID, String name, String email, String Major, String Minor, double gpa, int mtrId, String date_of_birth) 
    {
        String peeTemplate = "INSERT INTO person (samID, name, email, date_of_birth) VALUES (%d,'%s','%s','%s')";
        String pee = String.format(peeTemplate, samID, name, email,date_of_birth);
        String cmdTemplate = "INSERT INTO Student (samID , Major, Minor, GPA, mtrId) VALUES (%d, '%s', '%s', %f, %d)";
        String cmd = String.format(cmdTemplate, samID, Major, Minor, gpa, mtrId);
        try (PreparedStatement personStatement = sqlUtil.getConnection().prepareStatement(peeTemplate);
                PreparedStatement studentStatement = sqlUtil.getConnection().prepareStatement(cmdTemplate);
                )
        {
            //parameters to insert into person table
            personStatement.setInt(1, samID);
            personStatement.setString(2, name);
            personStatement.setString(3, email);
            personStatement.setString(4, date_of_birth);
            
            //parameters to insert into Student table
            studentStatement.setInt(1, samID);
            studentStatement.setString(2, Major);
            studentStatement.setString(3, Minor);
            studentStatement.setDouble(4, gpa);
            studentStatement.setInt(5 ,mtrId);
            
            //insertion transaction
            sqlUtil.getConnection().setAutoCommit(false);
            personStatement.executeUpdate();
            studentStatement.executeUpdate();
            sqlUtil.getConnection().commit();
            
            return 1;//mark success
        } catch (SQLException ex) {
            Logger.getLogger(StudentHandler.class.getName()).log(Level.SEVERE, null, ex);
            return 0;//mark failure 
        }
    }
    
    public List<Student> loadStudents(String keyword){
        
            List<Student> students = new ArrayList<>();
            String cmdTemplate = "select samID, name, email, dadte_of_birth, Major, Minor, GPA, mtrId from Student where name like '%s'";
            String cmd = String.format(cmdTemplate, "%" + keyword + "%");
            ResultSet rs = sqlUtil.executeQuery(cmd);
        try {    
            while(rs!=null && rs.next()){
                int samID = rs.getInt("samID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String Major = rs.getString("Major");
                String Minor = rs.getString("Minor");
                double gpa = rs.getDouble("GPA");
                int mtrId = rs.getInt("mtrName");
                String date_of_birth = rs.getString( "date_of_birth");
                Student student = new Student(samID, name, Major, Minor, gpa, mtrId, date_of_birth);
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

    public int updateStudent(String name, String Major, String Minor, double gpa, int mtrId, String date_of_birth){
        String cmdTemplate = "update Student set name='%s', Major='%s', Minor='%s' GPA='%d', mtrId='%d', date_of_birth='%s'";
        String stmStr=String.format(cmdTemplate, name, Major, Minor, gpa, mtrId);
        return sqlUtil.executeUpdate(stmStr);
    }

    public List<Student> getStudents(String keyword)
    {
        List <Student> students = new ArrayList<>();
        String cmdTemplate = "SELECT s.samID, p.name, p.email, p.date_of_birth, s.Major, s.Minor, s.GPA, s.mtrID"+
                             "FROM Student s " +
                             "INNER JOIN person p on s.samID = p.samID";
        
        try(PreparedStatement preparedStatement = sqlUtil.getConnection().prepareStatement(cmdTemplate);
            ResultSet rs = preparedStatement.executeQuery())
        {
            int samID  = rs.getInt("samID");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String Dob = rs.getString("date_of_birth");
            String Major = rs.getString("Major");
            String Minor = rs.getString("Minor");
            double gpa = rs.getDouble("GPA");
            int mtrID =rs.getInt("mtrID");
            
            Student student = new Student(samID, name, Major, Minor, gpa, mtrID, Dob);
            students.add(student);
        }
        catch(SQLException ex)
        {
           Logger.getLogger(StudentHandler.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return students;
    }
       
}
