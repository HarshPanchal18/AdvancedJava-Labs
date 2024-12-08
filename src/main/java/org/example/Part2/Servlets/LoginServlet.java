package org.example.Part2.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("123")) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            Cookie cookie = new Cookie("password", password);
            cookie.setMaxAge(60 * 60);

            response.addCookie(cookie);
            response.sendRedirect("Dashboard");
        } else {
            response.setContentType("text/html");

            response.getWriter().println("<h3>Invalid username or password!</h3>");
            response.getWriter().println("<h3>" + username + "</h3>");
            response.getWriter().println("<h3>" + password + "</h3>");
            response.getWriter().println("<a href=\"index.html\">Try Again</a>");
        }

    }

}