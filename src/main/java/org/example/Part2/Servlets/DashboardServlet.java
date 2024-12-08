package org.example.Part2.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DashboardServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String password = null;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                    break;
                }
            }
        }

        response.setContentType("text/html");

        response.getWriter().println("<h1>Welcome to the Dashboard</h1>");
        response.getWriter().println("<p>From Session: </p>");
        response.getWriter().println("<p>Hello, " + session.getAttribute("username") + "!</p>");
        response.getWriter().println("<p>From cookie: </p>");
        response.getWriter().println("<p>Hello, " + password + "!</p>");
        response.getWriter().println("<a href='LogoutServlet'>Logout</a>");

    }

}