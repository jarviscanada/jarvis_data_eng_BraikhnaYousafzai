package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataAccessObject;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends DataAccessObject<Order> {

    private static final String find = "SELECT c.first_name AS customer_first_name, " +
            "c.last_name AS customer_last_name, c.email AS customer_email, " +
            "o.order_id, o.creation_date, o.total_due, o.status, " +
            "s.first_name AS sales_first_name, s.last_name AS sales_last_name, s.email AS sales_email," +
            "ol.quantity, p.code, p.name, p.size, p.variety, p.price " +
            "FROM orders o " +
            "join customer c on o.customer_id=c.customer_id " +
            "join salesperson s on o.salesperson_id=s.salesperson_id " +
            "join order_item ol on ol.order_id=o.order_id " +
            "join product p on ol.product_id=p.product_id " +
            "where o.order_id=?";

    public OrderDAO (Connection connection){
        super(connection);
    }

    @Override
    public Order findById(long id) {
        Order order = new Order();
        try(PreparedStatement statement = this.connection.prepareStatement(find)){
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            long orderId=0;
            List<OrderLine> orderLines = new ArrayList<>();
            while (rs.next()){
                if(orderId==0) {
                    order.setCustomer_first_name(rs.getString("customer_first_name"));
                    order.setCustomer_last_name(rs.getString("customer_last_name"));
                    order.setCustomer_email(rs.getString("customer_email"));
                    order.setId(rs.getLong("order_id"));
                    orderId = order.getId();
                    order.setOrder_creation_date(rs.getDate("creation_date"));
                    order.setOrder_total_due(rs.getFloat("total_due"));
                    order.setOrder_status(rs.getString("status"));
                    order.setSales_first_name(rs.getString("sales_first_name"));
                    order.setSales_last_name(rs.getString("sales_last_name"));
                    order.setSales_email(rs.getString("sales_email"));
                }
                OrderLine orderLine = new OrderLine();
                orderLine.setOrder_item_quantity(rs.getInt("quantity"));
                orderLine.setProduct_code(rs.getString("code"));
                orderLine.setProduct_name(rs.getString("name"));
                orderLine.setProduct_size(rs.getInt("size"));
                orderLine.setProduct_variety(rs.getString("variety"));
                orderLine.setProduct_price(rs.getFloat("price"));
                orderLines.add(orderLine);
            }
            order.setOrderLines(orderLines);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order update(Order dto) {
        return null;
    }

    @Override
    public Order create(Order dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
