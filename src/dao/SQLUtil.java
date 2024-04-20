package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SQLUtil {
    private Connection con;
    private Statement stm;

    protected Connection getConnection(){
        try{
            if (con == null || con.isClosed()){
                String url = "directory for my sql server";
                String username = "root";
                String password = "root";
                try { 
                    con = DriverManager.getConnection(url, username, password);
                }catch (SQLException ex){
                    Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        } catch (SQLException ex){
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

private Statement getStatement(){
    if (stm == null){
        try{
            stm = getConnection().createStatement();

            }catch (SQLException ex){
                Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return stm;
    }

    public int executeUpdate(String stmStr){
        int ret = 0;
        try{
            ret  = getStatement().executeUpdate(stmStr);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public ResultSet executeQuery(String queryStr){
        ResultSet ret = null;
        try {
            ret = getStatement().executeQuery(queryStr);
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    public void closeConnection() {
        try {
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(SQLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}