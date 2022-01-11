package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataTransferObject;

import java.util.Date;
import java.util.List;

public class Order implements DataTransferObject{

    private String customer_first_name;
    private String customer_last_name;
    private String customer_email;
    private long id;
    private Date order_creation_date;
    private float order_total_due;
    private String order_status;
    private String sales_first_name;
    private String sales_last_name;
    private String sales_email;
    private List<OrderLine> orderLines;


    public String getCustomer_first_name() {
        return customer_first_name;
    }

    public void setCustomer_first_name(String customer_first_name) {
        this.customer_first_name = customer_first_name;
    }

    public String getCustomer_last_name() {
        return customer_last_name;
    }

    public void setCustomer_last_name(String customer_last_name) {
        this.customer_last_name = customer_last_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrder_creation_date() {
        return order_creation_date;
    }

    public void setOrder_creation_date(Date order_creation_date) {
        this.order_creation_date = order_creation_date;
    }

    public float getOrder_total_due() {
        return order_total_due;
    }

    public void setOrder_total_due(float order_total_due) {
        this.order_total_due = order_total_due;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getSales_first_name() {
        return sales_first_name;
    }

    public void setSales_first_name(String sales_first_name) {
        this.sales_first_name = sales_first_name;
    }

    public String getSales_last_name() {
        return sales_last_name;
    }

    public void setSales_last_name(String sales_last_name) {
        this.sales_last_name = sales_last_name;
    }

    public String getSales_email() {
        return sales_email;
    }

    public void setSales_email(String sales_email) {
        this.sales_email = sales_email;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer_first_name='" + customer_first_name + '\'' +
                ", customer_last_name='" + customer_last_name + '\'' +
                ", customer_email='" + customer_email + '\'' +
                ", id=" + id +
                ", order_creation_date=" + order_creation_date +
                ", order_total_due=" + order_total_due +
                ", order_status='" + order_status + '\'' +
                ", sales_first_name='" + sales_first_name + '\'' +
                ", sales_last_name='" + sales_last_name + '\'' +
                ", sales_email='" + sales_email + '\'' +
                ", orderLines=" + orderLines +
                '}';
    }
}
