package Connects;

import controller.UserDBC;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Roles {
    private int rid;
    private String role;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static String findRole(User user){
        UserDBC connect = new UserDBC();
        Connection con = null;
        Statement stmt = null;
        String kullanici_adi ="postgres";
        String parola ="server1";
        String role = "";
        if(true)
        {
            try {
                System.out.println("Connecting database...");
                Class.forName("org.postgresql.Driver");
                con =  (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",kullanici_adi,parola);
                System.out.println("Creating statement...");
                stmt = con.createStatement();
                String sql;
                sql = "select * from roles where rid ="+ user.getRid();
                ResultSet rs = stmt.executeQuery(sql);
                //extract unique data

                while (rs.next()) {
                    role = rs.getString("rname");
                    //Display
                    System.out.println("CID : " + role);
                }
                rs.close();
                stmt.close();
                con.close();
            }
            catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UserDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                //finally block used to close resources
                try{
                    if(stmt!=null)
                        stmt.close();
                }catch(SQLException se2){
                }// nothing we can do
                try{
                    if(con!=null)
                        con.close();
                }catch(SQLException se){
                    se.printStackTrace();
                }//end finally try
            }
        }
        return role;
    }


}
