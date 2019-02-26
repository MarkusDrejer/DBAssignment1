import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {

    private Connection con;

    public DB(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://den1.mysql5.gear.host/assignmentdb1", "assignmentdb1", "Ah3vVjoep?!d");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> selectProducts() {
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

        statementExecute(sql_Update);
    }

    public void deleteProduct(int itemID){
        String sql_Delete = "DELETE FROM products " +
                "WHERE Pid = " + itemID;

        statementExecute(sql_Delete);
    }

    public void insertProduct(String name, int price, String location) {
        String sql_Input = "INSERT INTO products (Product_name, Product_price, Product_location) " +
                "VALUES ('"+ name +"',"+ price +",'"+ location +"')";

        statementExecute(sql_Input);
    }

    public List<Integer> allIds(){
        String sql_Ids = "SELECT Pid FROM products";
        List<Integer> idList = new ArrayList<>();

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql_Ids);

            while(rs.next()){
                idList.add(rs.getInt("Pid"));
            }
            stmt.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return idList;
    }

    /**
     * Statement helper method
     */
    private void statementExecute(String sql){
        try {
            Statement stmt = con.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}