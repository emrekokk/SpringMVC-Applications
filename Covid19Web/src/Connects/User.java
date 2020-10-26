package Connects;


import controller.UserDBC;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    private String fname;
    private String lname;
    //@NotBlank(message = "username can not be empty")
    private String username;
    private String password;
    private int rid;
    private int countryID;
    private String rname;

    public String getUsername() {
        return username;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public static User findUser(String username){
        User user = new User();
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
                sql = "select * from users where id ="+ username;
                ResultSet rs = stmt.executeQuery(sql);
                //extract unique data

                while (rs.next()) {
                    String id = rs.getString("id");
                    String fname = rs.getString("fname");
                    String lname = rs.getString("lname");
                    String pass = rs.getString("pass");
                    int rid = rs.getInt("rid");
                    int countryid = rs.getInt("countryID");
                    String rname = rs.getString("rname");
                    //Display
                    System.out.println("CID : " + id);
                    user = new User();
                    user.setRid(rid);
                    user.setFname(fname);
                    user.setLname(lname);
                    user.setUsername(id);
                    user.setCountryID(countryid);
                    user.setPassword(pass);
                    user.setRname(rname);
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
        return user;
    }
    public static boolean checkUser(String username){
        Connection con = null;
        Statement stmt = null;
        boolean founded = false;
        String kullanici_adi ="postgres";
        String parola ="server1";
        if(true)
        {
            try {
                System.out.println("Connecting database...");
                Class.forName("org.postgresql.Driver");
                con =  (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",kullanici_adi,parola);
                System.out.println("Creating statement...");
                stmt = con.createStatement();
                String sql;
                sql = "select id from users";
                System.out.println("query");
                ResultSet rs = stmt.executeQuery(sql);
                //extract unique data

                while (rs.next()) {
                    String id = rs.getString("id");
                    //Display
                    System.out.println("CID : " + id);
                    System.out.println("rsnext");
                    if (id == username) {
                        return true;
                    }
                }

                rs.close();
                stmt.close();
                con.close();
            }
            catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UserDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{

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
        return founded;
    }
    public static User createUser(User user){
        Connection con = null;
        Statement stmt = null;
        boolean founded = false;
        String kullanici_adi ="postgres";
        String parola ="server1";
        if(true)
        {
            try {
                System.out.println("Connecting database...");
                Class.forName("org.postgresql.Driver");
                con =  (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",kullanici_adi,parola);
                System.out.println("Creating statement...");
                stmt = con.createStatement();
                String sql,sql2;
                String x = "'";
                sql = "insert into users values ("+ "'" +user.getUsername()+ "'" + ","
                        +user.getPassword()+ ","+ "'" +user.getFname()+ "'" + ","+ "'" +user.getLname()+ "'" +","+" 2,"+user.getCountryID()+")";
                sql2 = "insert into users values ( )";
                stmt.executeUpdate(sql);
                //extract unique data
                stmt.close();
                con.close();
            }
            catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UserDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{

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
        return user;
    }
}
