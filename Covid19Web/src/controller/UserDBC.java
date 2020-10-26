package controller;

import Connects.User;

import javax.jws.soap.SOAPBinding;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDBC{
    private String kullanici_adi ="postgres";
    private String parola ="server1";
    public Connection con;
    Statement stmt = null;
    public ArrayList<User> userlist = new ArrayList<User>();

    public UserDBC() {

    }

    public UserDBC(ArrayList<User> userlist) {
        this.userlist = userlist;
    }

    public UserDBC(String s, int i) {
    }

    public ArrayList<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(ArrayList<User> userlist) {
        this.userlist = userlist;
    }
    /*
    public String JSONconverter(ArrayList<User> userlist){
        Gson gson = new Gson();
        String JSON = gson.toJson(userlist);
        return JSON;
    }
    */
    public String toString()
    {
        for (int i = 0; i < this.getUserlist().size(); i++){
            System.out.println(this.getUserlist().get(i).getUsername() + " " + this.getUserlist().get(i).getRid() + " " + this.getUserlist().get(i).getFname() + " \n" + this.getUserlist().get(i).getRname());
        }
        return null;
    }

    public void connectDBUser() {
        UserDBC connect = new UserDBC();
        User temp = new User();
        if(true)
        {
            try {
                System.out.println("Connecting database...");
                Class.forName("org.postgresql.Driver");
                con =  (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",kullanici_adi,parola);
                System.out.println("Creating statement...");
                stmt = con.createStatement();

                String sql;
                sql = "select * from users,roles where roles.rid = users.rid";
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
                    temp.setRid(rid);
                    temp.setFname(fname);
                    temp.setLname(lname);
                    temp.setUsername(id);
                    temp.setCountryID(countryid);
                    temp.setPassword(pass);
                    temp.setRname(rname);
                    this.userlist.add(temp);
                    temp = new User();
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
    }
}
