public class Product {
    private int Pid;
    private String Product_name;
    private String Product_location;
    private int Product_price;

    public int getPid() {
        return Pid;
    }

    public void setPid(int pid) {
        Pid = pid;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public String getProduct_location() {
        return Product_location;
    }

    public void setProduct_location(String product_location) {
        Product_location = product_location;
    }

    public int getProduct_price() {
        return Product_price;
    }

    public void setProduct_price(int product_price) {
        Product_price = product_price;
    }

    public String toString(){
        return "ID: " + Pid + " " +
                "Name: " + Product_name + " " +
                "Price: " + Product_price + " " +
                "Location: " + Product_location + "\n";
    }
}
