
package jdbc;

import java.sql.*;

public class Jdbc {
    static final String url = "jdbc:postgresql://192.168.100.109/my_test";
    static final String user = "sandro";
    static final String password = "";
    
    public static void main(String[] args){
        Connection conn = null; //???
        Statement stmt = null;
        try{
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(url,user,password);
        
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT id, name, country_id FROM cars";
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int country_id = rs.getInt("country_id");
            
            System.out.print("id:" + id);
            System.out.print(", country:" + name);
            System.out.println(", country_id:" + country_id);
            
        }
        rs.close();
        stmt.close();
        conn.close();
    }catch(SQLException se){
        //errorebistvis
        se.printStackTrace();
    }finally{
    try{
        if(stmt!=null)
            stmt.close();
    }catch(SQLException se){
        
    }
    try{
        if(conn!= null)
            conn.close();
    }catch(SQLException se){
        se.printStackTrace();
            }
        }
        System.out.println("end...");
    }
}
        
