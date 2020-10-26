import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Covid19DBC{

    private String kullanici_adi ="postgres";
    private String parola ="server1";
    public Connection con;
    Statement stmt = null;
    public String cnameT;
    public int cidT;
     public void connectDB() {
        if(true)
        {
            try {
                System.out.println("Connecting database...");
                Class.forName("org.postgresql.Driver");
                con =  (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",kullanici_adi,parola);
                System.out.println("Creating statement...");
                stmt = con.createStatement();

                String sql;
                sql = "SELECT cid,cname FROM country";
                ResultSet rs = stmt.executeQuery(sql);
                //extract unique data
                while (rs.next()) {
                    int cid = rs.getInt("cid");
                    String cname = rs.getString("cname");
                    //Display
                    System.out.println("CID : " + cid);
                    System.out.println("CNAME " + cname);
                    cnameT = cname;
                    cidT = cidT;
                }
                //cleanup
                rs.close();
                stmt.close();
                con.close();
            }
            catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Covid19DBC.class.getName()).log(Level.SEVERE, null, ex);
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

    public static void main(String[] args) {
        Covid19DBC cvd = new Covid19DBC();
        cvd.connectDB();
    }
}