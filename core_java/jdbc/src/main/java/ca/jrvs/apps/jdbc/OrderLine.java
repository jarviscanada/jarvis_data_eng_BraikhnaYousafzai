package ca.jrvs.apps.jdbc;

public class OrderLine {

    private int order_item_quantity;
    private String product_code;
    private String product_name;
    private int product_size;
    private String product_variety;
    private float product_price;

    public int getOrder_item_quantity() {
        return order_item_quantity;
    }

    public void setOrder_item_quantity(int order_item_quantity) {
        this.order_item_quantity = order_item_quantity;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_size() {
        return product_size;
    }

    public void setProduct_size(int product_size) {
        this.product_size = product_size;
    }

    public String getProduct_variety() {
        return product_variety;
    }

    public void setProduct_variety(String product_variety) {
        this.product_variety = product_variety;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "order_item_quantity=" + order_item_quantity +
                ", product_code='" + product_code + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_size=" + product_size +
                ", product_variety='" + product_variety + '\'' +
                ", product_price=" + product_price +
                '}';
    }
}
