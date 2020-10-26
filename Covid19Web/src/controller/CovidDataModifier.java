package controller;

import Connects.DailyData;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CovidDataModifier {
    @Transactional
    public DailyData setCovidDailyData(DailyData newdata){
        DailyData temp = new DailyData();
        UserDBC connect = new UserDBC();
        Connection con = null;
        Statement stmt=null;
        String kullanici_adi ="postgres";
        String parola ="server1";
        if(true)
        {
            try {
                System.out.println("Connecting database...");
                Class.forName("org.postgresql.Driver");
                con =  (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",kullanici_adi,parola);
                System.out.println("Executing query...");
                stmt = con.createStatement();
                //if( newdata.getAy().equals("MAY") || !newdata.getAy().equals("05") || !newdata.getAy().equals(5))
                //    newdata.setAy("05");
                String editday = "'" + newdata.getYil() + newdata.getAy() + newdata.getGun() + "'";
                String days = "'" + newdata.getYil() + newdata.getAy() + newdata.getGun() + "'";
                String sql = "UPDATE CVDATA " +
                        "SET numCase =" + newdata.getNumCase()+ ","+
                        "numTest = " + newdata.getNumTest() +","+
                        "numIntubated = " + newdata.getNumIntubated()+ "," +
                        "numICU = " + newdata.getNumICU()+ "," +
                        "numrevocered = " + newdata.getNumRecovered()+","+
                        "numDeceased = " + newdata.getNumDeceased() +
                "WHERE countryid ="+ newdata.getCountryID() +"AND day =" +editday ;
                stmt.executeUpdate(sql);
                //ResultSet rs = stmt.executeQuery(sql);
                //extract unique data
                /*
                while (rs.next()) {
                    int id = rs.getInt("countryid");
                    //Date date = rs.getDate("day");
                    int numtest = rs.getInt("numtest");
                    int numcase = rs.getInt("numcase");
                    int numintubated = rs.getInt("numintubated");
                    int numicu = rs.getInt("numicu");
                    int numrevocered = rs.getInt("numrevocered");
                    int deceased = rs.getInt("numdeceased");
                    //Display
                    //System.out.println("CID : " + id);
                    temp.setCountryID(id);
                    temp.setNumTest(numtest);
                    temp.setNumCase(numcase);
                    temp.setNumIntubated(numintubated);
                    temp.setNumICU(numicu);
                    temp.setNumRecovered(numrevocered);
                    temp.setNumDeceased(deceased);
                }
                rs.close();
                 */
                stmt.close();
                con.close();
            }
            catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UserDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                //finally block used to close resources
                System.out.println("Records updated succesfully");
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
        return newdata;
    }
    public DailyData deleteCovidDailyData(DailyData newdata){
        Connection con = null;
        Statement stmt=null;
        String kullanici_adi ="postgres";
        String parola ="server1";
        if(true)
        {
            try {
                System.out.println("Connecting database...");
                Class.forName("org.postgresql.Driver");
                con =  (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",kullanici_adi,parola);
                System.out.println("Executing query...");
                stmt = con.createStatement();

                String editday = "'" + newdata.getYil() + newdata.getAy() + newdata.getGun() + "'";
                String sql = "Delete from cvdata where day ="+editday+"AND countryid =" + newdata.getCountryID();
                stmt.execute(sql);

                stmt.close();
                con.close();
            }
            catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UserDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                //finally block used to close resources
                System.out.println("Records deleted succesfully");
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
        return newdata;
    }
    public static void deleteAllData(){
        Connection con=null;
        Statement stmt=null;
        String kullanici_adi ="postgres";
        String parola ="server1";
        if(true)
        {
            try {
                System.out.println("Connecting database...");
                Class.forName("org.postgresql.Driver");
                con =  (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",kullanici_adi,parola);
                System.out.println("Executing query...");
                stmt = con.createStatement();

                String sql;
                sql="delete from users where USERS.fName <> '  '";
                stmt.executeUpdate(sql);
                sql = "delete from roles where roles.rname <> ' '";
                stmt.executeUpdate(sql);
                sql ="delete from CVDATA where numcase <> -333";
                stmt.executeUpdate(sql);
                sql = "delete from country where country.cname <> '  '";
                stmt.executeUpdate(sql);

                stmt.close();
                con.close();
            }
            catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UserDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                //finally block used to close resources
                System.out.println("All Records deleted succesfully");
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

    public DailyData insertCovidDailyData(DailyData newdata) {
        Connection con = null;
        Statement stmt=null;
        String kullanici_adi ="postgres";
        String parola ="server1";
        if(true)
        {
            try {
                System.out.println("Connecting database...");
                Class.forName("org.postgresql.Driver");
                con =  (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",kullanici_adi,parola);
                System.out.println("Executing query...");
                stmt = con.createStatement();

                String editday = "'" + newdata.getYil() + "-" + newdata.getAy() + "-" + newdata.getGun() + "'";
                String sql = "INSERT INTO cvdata VALUES(" + newdata.getCountryID() + "," + editday + "," + newdata.getNumTest() + "," + newdata.getNumCase() +
                        "," + newdata.getNumIntubated() + "," + newdata.getNumICU() + "," + newdata.getNumRecovered() + "," + newdata.getNumDeceased() + ")";
                stmt.executeUpdate(sql);
                stmt.close();
                con.close();
            }
            catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UserDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                //finally block used to close resources
                System.out.println("Records inserted succesfully");
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
        return newdata;
    }
    public static ArrayList<DailyData> totalGraphCaseCounter( UserController.MyDay begin, UserController.MyDay end){
        ArrayList<DailyData> dlist = CovidDataGetter.getDataOrderDay(begin,end);
        ArrayList<DailyData> x = dlist;

        for(int i = 0 ; i < dlist.size() ; i++){
            x.get(i+1).setNumDeceased(dlist.get(i).getNumDeceased()+dlist.get(i+1).getNumDeceased());
            x.get(i+1).setNumCase(dlist.get(i).getNumCase()+dlist.get(i+1).getNumCase());
            x.get(i+1).setNumTest(dlist.get(i).getNumTest()+dlist.get(i+1).getNumTest());
            System.out.println(x.get(i).getNumCase());
            System.out.println(x.get(i).getNumTest());
            System.out.println(x.get(i).getNumDeceased());
        }

        return x;
    }
}
