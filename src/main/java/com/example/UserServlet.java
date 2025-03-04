package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServlet extends HttpServlet {

    // Method to handle the /user URL and display data from MySQL
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        // Set the content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // HTML structure for the page
        out.println("<html><body>");
        out.println("<h1>User Data from MySQL</h1>");

        // Fetch and display data from the database
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM users"; // Query to fetch user data
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>Error connecting to the database: " + e.getMessage() + "</p>");
        }

        out.println("</body></html>");
    }
}