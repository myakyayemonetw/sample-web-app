package com.example;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        // Get the PrintWriter from the response object
        PrintWriter out = response.getWriter();

        // Send a simple message to the browser
        out.println("Hello, Jakarta Servlet!");

        // Test the database connection
        DatabaseConnection.testConnection();

        // Print the response message with HTML content
        out.println("<html><body>");
        out.println("<h1>Testing Database Connection</h1>");
        out.println("<p>Check your server logs for the database connection result.</p>");
        out.println("</body></html>");
    }
}
