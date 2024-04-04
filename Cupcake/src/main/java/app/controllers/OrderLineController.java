package app.controllers;

import app.entities.OrderLine;
import app.exceptions.DatabaseException;
import app.persistence.ConnectionPool;
import app.persistence.OrderLineMapper;
import io.javalin.http.Context;
import io.javalin.Javalin;

import java.util.List;

public class OrderLineController {

    public static void addRoutes(Javalin app, ConnectionPool connectionPool) {
        // Define route to show order list
        app.get("/orderList", ctx -> showOrderList(ctx, connectionPool));
    }
    public static void showOrderList(Context ctx, ConnectionPool connectionPool) {
        try {
            // Retrieve the order list from the database using your connectionPool
            List<OrderLine> orderLineList = OrderLineMapper.getOrderLine(connectionPool);

            // Add the order list to the context
            ctx.attribute("orderList", orderLineList);

            // Render the order list view
            ctx.render("OrderLine.html");
        } catch (DatabaseException e) {
            // Handle database exception
            ctx.status(500).result("Error retrieving order list: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Handle number format exception
            ctx.attribute("message", "Invalid format for order list: " + e.getMessage());
            ctx.render("index.html");
        }
    }

}
