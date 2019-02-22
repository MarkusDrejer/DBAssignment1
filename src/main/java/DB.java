import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {

    Connection con;

    public DB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager
                    .getConnection("jdbc:mysql://den1.mysql5.gear.host/assignmentdb1", "assignmentdb1", "Ah3vVjoep?!d");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> selectProducts(){
        List<Product> productList = new ArrayList<Product>();
        String sql_Select = "SELECT * FROM products;";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql_Select);

            while(rs.next()){
                productList.add(new Product(rs.getInt("Pid"),
                        rs.getString("Product_name"),
                        rs.getInt("Product_price"),
                        rs.getString("Product_location")));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return productList;
    }
}
