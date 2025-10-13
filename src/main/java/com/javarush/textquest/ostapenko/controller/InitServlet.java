package com.javarush.textquest.ostapenko.controller;

import com.javarush.textquest.ostapenko.model.QuestService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "initServlet", value = "/index.jsp")
public class InitServlet extends HttpServlet {
    private QuestService questService;

    @Override
    public void init() throws ServletException {
        questService = new QuestService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("startPageData",questService.getStartPageData());
        req.getSession().setAttribute("gameSession",questService.getGameSession());
        resp.sendRedirect(req.getContextPath()+"/start");
    }
}
