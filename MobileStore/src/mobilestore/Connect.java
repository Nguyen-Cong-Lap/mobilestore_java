package mobilestore;
import java.sql.*;
public class Connect {
    public Connection getConnection(){
        Connection conn= null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=MobileStore;encrypt=true;trustServerCertificate=true","sa","sa");
            if(conn!=null){
                System.out.println("ket noi thanh cong");
            }
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
        return conn;
    }
}
