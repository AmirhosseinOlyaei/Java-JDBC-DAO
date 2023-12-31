import java.sql.*;
import java.util.ArrayList;
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
    public void insertPainting(String title){
        try{
            // insert something into table
            PreparedStatement ps3 = conn.prepareStatement("insert into painting (title) values (?)");
            ps3.setString(1, title);
            ps3.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<String> getAllPaintingNames(){
        List<String> paintings = new ArrayList<>();
        try{
            // query everything from the table and display the result
            PreparedStatement ps4 = conn.prepareStatement("select * from painting");
            ResultSet rs = ps4.executeQuery();
            while(rs.next()){
                // System.out.println(rs.getString("title"));
                // loop through every row in my result set, until it has no more items
                paintings.add(rs.getString("title"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return paintings;
    }
}