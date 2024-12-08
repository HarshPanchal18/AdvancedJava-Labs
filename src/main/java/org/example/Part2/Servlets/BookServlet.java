package org.example.Part2.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.http.*;

public class BookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String bookId = request.getParameter("bookid");

        if (bookId == null || bookId.isEmpty()) {
            response.getWriter().println("<h1>Enter book id: </h1>");
            return;
        }

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");
            String query = "select * from book where id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(bookId));
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                response.getWriter().println("<h1>" + rs.getInt("id") + " - " + rs.getString("title") + "</h1>");
                response.getWriter().println("<p>" + rs.getString("author") + "</p>");
                response.getWriter().println("<p>" + rs.getString("price") + "</p>");
            } else {
                response.getWriter().println("<h2>No book found with this ID!!</h2>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error: " + e.getMessage());
        }

    }

}