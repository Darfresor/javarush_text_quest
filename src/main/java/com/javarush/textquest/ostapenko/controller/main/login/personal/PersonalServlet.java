package com.javarush.textquest.ostapenko.controller.main.login.personal;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PersonalServlet", value = "/personal")
public class PersonalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher  = req.getRequestDispatcher("/WEB-INF/views/personal.jsp");
        dispatcher.forward(req, resp);
    }
}
