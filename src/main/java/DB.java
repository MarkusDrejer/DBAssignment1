import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {

    Connection con;

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

    public void insertProduct(String name, String location, int price) {
        String sql = "INSERT INTO products (Product_name, Product_location, Product_price) " +
                "VALUES ('"+ name +"','"+ location +"',"+ price +")";

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
