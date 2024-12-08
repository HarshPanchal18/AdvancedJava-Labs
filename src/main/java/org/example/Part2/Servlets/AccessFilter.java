package org.example.Part2.Servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String bookId = httpRequest.getParameter("bookid");

        if (bookId == null || bookId.isEmpty())
            httpResponse.sendRedirect("invalid.html");
        else
            filterChain.doFilter(request, response);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}