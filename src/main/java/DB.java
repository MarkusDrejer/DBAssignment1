import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {

    private Connection con;

    public DB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://den1.mysql5.gear.host/assignmentdb1", "assignmentdb1", "Ah3vVjoep?!d");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> selectProducts(){
        List<Product> productList = new ArrayList<Product>();

        String sql_Select = "SELECT * FROM products";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql_Select);

            while(rs.next()){
                Product tmp = new Product();
                tmp.setPid(rs.getInt("Pid"));
                tmp.setProduct_name(rs.getString("Product_name"));
                tmp.setProduct_price(rs.getInt("Product_price"));
                tmp.setProduct_location(rs.getString("Product_location"));
                productList.add(tmp);
            }

            stmt.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return productList;
    }

    public void updateProduct(String name, int price, String location, int itemID){
        String sql_Update = "UPDATE products " +
                "SET Product_name = '" + name + "', Product_price = " + price + ", Product_location = '" + location + "' " +
                "WHERE Pid = " + itemID;

        try {
            Statement stmt = con.createStatement();
            stmt.execute(sql_Update);
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteProduct(int itemID){
        String sql_Delete = "DELETE FROM products " +
                "WHERE Pid = " + itemID;

        try {
            Statement stmt = con.createStatement();
            stmt.execute(sql_Delete);
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertProduct(String name, int price, String location) {
        String sql_Input = "INSERT INTO products (Product_name, Product_price, Product_location) " +
                "VALUES ('"+ name +"',"+ price +",'"+ location +"')";

        try {
            Statement stmt = con.createStatement();
            stmt.execute(sql_Input);
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public int[] allIds(){
        String sql_Ids = "SELECT Pid FROM products";
        int[] idList = new int[idCount()];

        try {
            int counter = 0;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql_Ids);

            while(rs.next()){
                idList[counter] = rs.getInt("Pid");
                counter++;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return idList;
    }

    private int idCount(){
        String sql_IdCount = "SELECT COUNT(Pid) FROM products";
        int ids = 0;

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql_IdCount);

            while (rs.next()) {
                ids = rs.getInt("COUNT(Pid)");
            }
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return ids;
    }
}