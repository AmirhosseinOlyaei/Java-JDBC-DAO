import java.sql.*;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args){
        PaintingDAO paintingDAO = new PaintingDAO();
        paintingDAO.dropPaintingTable();
        paintingDAO.setUpPaintingTable();
//        paintingDAO.insertPainting("Guernica");
//        paintingDAO.insertPainting("Composition x");
//        paintingDAO.insertPainting("Gentle ascent");
//        paintingDAO.getAllPaintingNames();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the painting you wish to add: ");
            String input = sc.nextLine();
            paintingDAO.insertPainting(input);
            System.out.println("Here are all your paintings so far");
            List<String> myPaintings = paintingDAO.getAllPaintingNames();
            System.out.println(myPaintings);
        }
    }
}
