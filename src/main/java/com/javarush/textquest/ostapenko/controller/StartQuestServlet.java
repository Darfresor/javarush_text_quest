package com.javarush.textquest.ostapenko.controller;

import com.javarush.textquest.ostapenko.model.QuestService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="StartQuestServlet", value="/quests/start")
public class StartQuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestService qs = QuestService.getInstance();
        String textId = req.getParameter("id");
        System.out.println("read param id = "+ textId);

        RequestDispatcher dispatcher  = req.getRequestDispatcher("/WEB-INF/views/startQuests.jsp");
        dispatcher.forward(req, resp);
    }
}
