package app.persistence;

import app.entities.OrderLine;
import app.exceptions.DatabaseException;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderLineMapper {
    public static List<OrderLine> getOrderLine(ConnectionPool connectionPool) throws DatabaseException {
        List<OrderLine> orderLineList = new ArrayList<>();
        String sql = "SELECT ol.orderline_id, ol.antal, ol.price, t.topping_name, b.bund_name " +
                "FROM public.orderline ol " +
                "JOIN public.topping t ON ol.topping_id = t.topping_id " +
                "JOIN public.bund b ON ol.bund_id = b.bund_id";

        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int orderLineId = rs.getInt("orderline_id");
                int antal = rs.getInt("antal");
                int price = rs.getInt("price");
                String topping = rs.getString("topping_name");
                String bund = rs.getString("bund_name");

                OrderLine orderLine = new OrderLine(orderLineId, antal, price, topping, bund);
                orderLineList.add(orderLine);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error retrieving order lines: " + e.getMessage());
        }
        return orderLineList;
    }

}



