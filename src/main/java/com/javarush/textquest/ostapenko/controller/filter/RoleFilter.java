package com.javarush.textquest.ostapenko.controller.filter;

import com.javarush.textquest.ostapenko.dto.UserDTO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/forum")
public class RoleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        if (session == null || session.getAttribute("userInfo") == null) {
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("/WEB-INF/views/notAccess.jsp");
            dispatcher.forward(httpRequest, httpResponse);
            return;
        }
        UserDTO userInfo = (UserDTO) session.getAttribute("userInfo");
        if(!userInfo.getUserRoles().contains("ADMIN")){
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher("/WEB-INF/views/notRole.jsp");
            dispatcher.forward(httpRequest, httpResponse);
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
