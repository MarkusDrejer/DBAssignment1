public class Product {
    private int Pid;
    private String Product_name;
    private String Product_location;
    private int Product_price;

    public void setPid(int pid) {
        Pid = pid;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public void setProduct_location(String product_location) {
        Product_location = product_location;
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
