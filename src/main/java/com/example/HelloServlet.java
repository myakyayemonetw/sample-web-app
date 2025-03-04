package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the content type for the response
        response.setContentType("text/html");

        // Get the output writer
        PrintWriter out = response.getWriter();
        
        // Test the database connection
        DatabaseConnection.testConnection();

        // Print the response message
        out.println("<html><body>");
        out.println("<h1>Testing Database Connection</h1>");
        out.println("<p>Check your server logs for the database connection result.</p>");
        out.println("</body></html>");
    }
}
