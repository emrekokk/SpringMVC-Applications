package controller;
import Connects.DailyData;
import Connects.User;
import controller.UserDBC;

import javax.swing.text.DateFormatter;
import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CovidDataGetter {


    public static DailyData getCovidDailyData(String yil,String ay,String gun, int countryId){
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
                    System.out.println("Creating statement...");
                    stmt = con.createStatement();
                    String sql;
                    System.out.println(ay);
                    //if( ay.equals("MAY") || !ay.equals("05") || !ay.equals(5))
                    //    ay = "05";
                    String days = "'" + yil + ay + gun + "'";
                    sql = "select * from cvdata where day = " + days +"and cvdata.countryid =" + countryId;
                    ResultSet rs = stmt.executeQuery(sql);
                    //extract unique data

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
            return temp;
    }
    public static DailyData getCovidDailyDataByCountry(String yil,String ay,String gun, int countryId){
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
                System.out.println("Creating statement...");
                stmt = con.createStatement();
                String sql;
                System.out.println(ay);
                //if( ay.equals("MAY") || !ay.equals("05") || !ay.equals(5))
                //    ay = "05";
                String days = "'" + yil + "-" + ay + "-" + gun + "'";
                sql = "select * from cvdata where day =" + days + "and cvdata.countryid =" + countryId;
                ResultSet rs = stmt.executeQuery(sql);
                //extract unique data

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
        return temp;
    }
    public static DailyData getCovidDailyData(String day){
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
                System.out.println("Creating statement...");
                stmt = con.createStatement();
                String sql;

                sql = "select * from cvdata where day = "+day;
                ResultSet rs = stmt.executeQuery(sql);
                //extract unique data

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
        return temp;
    }

    public static DailyData getTotaldata()
    {
        DailyData total = new DailyData();
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
                System.out.println("Creating statement...");
                stmt = con.createStatement();
                String
                sql = "select sum(cv.numTest) as totaltest, sum(cv.numDeceased) as totaldecease, sum(cv.numCase) as totalcase, sum(cv.numICU) as totalICU, sum(cv.numIntubated) as totalInt, sum(cv.numRevocered) as totalRec from cvdata cv";
                ResultSet rs = stmt.executeQuery(sql);
                //extract unique data

                while (rs.next()) {
                    //Date date = rs.getDate("day");
                    int numtest = rs.getInt("totaltest");
                    int numcase = rs.getInt("totalcase");
                    int numintubated = rs.getInt("totalInt");
                    int numicu = rs.getInt("totalICU");
                    int numrevocered = rs.getInt("totalRec");
                    int deceased = rs.getInt("totaldecease");
                    //Display
                    //System.out.println("CID : " + id);
                    total.setNumTest(numtest);
                    total.setNumCase(numcase);
                    total.setNumIntubated(numintubated);
                    total.setNumICU(numicu);
                    total.setNumRecovered(numrevocered);
                    total.setNumDeceased(deceased);
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
        return total;
    }
    public static ArrayList<DailyData> getDataOrderDay(UserController.MyDay startDay, UserController.MyDay endDay){
        DailyData dailyData = new DailyData();
        Connection con = null;
        Statement stmt = null;
        String kullanici_adi ="postgres";
        String parola ="server1";
        ArrayList<DailyData> dailylist = new ArrayList<>();
        if(true)
        {
            try {
                System.out.println("Connecting database...");
                Class.forName("org.postgresql.Driver");
                con =  (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",kullanici_adi,parola);
                System.out.println("Creating statement...");
                stmt = con.createStatement();
                String sql;
                sql = "select cvdata.numcase,cvdata.numtest,cvdata.numdeceased from cvdata where countryid=21 and day between"+
                        "'" +startDay.getDayof()+"-" + startDay.getMonth()+ "-" + startDay.getDayof() + "'" +
                        "and" + "'" +endDay.getDayof()+"-" + endDay.getMonth()+ "-" + endDay.getDayof() + "'";
                ResultSet rs = stmt.executeQuery(sql);
                //extract unique data

                while (rs.next()) {
                    int numcase = rs.getInt("numcase");
                    int numtest = rs.getInt("numtest");
                    int numdeceased = rs.getInt("numdeceased");
                    //Display
                    dailyData.setNumTest(numtest);
                    dailyData.setNumCase(numcase);
                    dailyData.setNumDeceased(numdeceased);
                    dailylist.add(dailyData);
                    dailyData = new DailyData();
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
        return dailylist;
    }
    public static int getCountryID(String countryName)
    {
        int cid = 0;
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
                System.out.println("Creating statement...");
                stmt = con.createStatement();
                String sql = "select cid from country where cname = " + "'" + countryName.toUpperCase() + "'";
                ResultSet rs = stmt.executeQuery(sql);
                //extract unique data

                while (rs.next())
                {
                    cid = rs.getInt("cid");
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
        return cid;
    }

}
