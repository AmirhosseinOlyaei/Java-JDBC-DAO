import java.sql.*;

public class Main {
    public static void main(String[] args){
        PaintingDAO paintingDAO = new PaintingDAO();
        paintingDAO.dropPaintingTable();
        paintingDAO.setUpPaintingTable();
        paintingDAO.insertPainting();
        paintingDAO.getAllPaintingNames();
    }
}