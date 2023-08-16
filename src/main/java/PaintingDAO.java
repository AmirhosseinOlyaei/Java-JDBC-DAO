import java.sql.*;
import java.util.List;

public class PaintingDAO {
    Connection conn;
    public PaintingDAO(){
        try{
            conn = DriverManager.getConnection("jdbc:h2:./h2/db");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void setUpPaintingTable(){
        try{
            //set up a new table
            PreparedStatement ps2 = conn.prepareStatement("create table painting(title varchar(255))");
            ps2.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void dropPaintingTable(){
        try{
            //drop any existing tables that exist
            PreparedStatement ps = conn.prepareStatement("drop table painting if exists");
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void insertPainting(){
        try{
            // insert something into table
            PreparedStatement ps3 = conn.prepareStatement("insert into painting (title) values ('guernica')");
            ps3.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<String> getAllPaintingNames(){
        try{
            // query everything from the table and display the result
            PreparedStatement ps4 = conn.prepareStatement("select * from painting");
            ResultSet rs = ps4.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("title"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}