package app.persistence;

import app.entities.Topping;
import app.exceptions.DatabaseException;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ToppingMapper {
    public static List<Topping> getToppings(ConnectionPool connectionPool) throws DatabaseException {
        List<Topping> toppingList = new ArrayList<>();
        String sql = "SELECT topping_id, topping_name, topping_price FROM public.topping";

        try (
                Connection connection = connectionPool.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int toppingID = rs.getInt("topping_id");
                String toppingName = rs.getString("topping_name");
                double toppingPrice = rs.getDouble("topping_price");

                Topping topping = new Topping(toppingID, toppingName, toppingPrice);
                toppingList.add(topping);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error retrieving toppings: " + e.getMessage());
        }
        return toppingList;
    }
}