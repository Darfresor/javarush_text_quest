package com.javarush.textquest.ostapenko.controller.main.quests.choice;

import com.javarush.textquest.ostapenko.dto.QuestListResponse;
import com.javarush.textquest.ostapenko.model.IQuestService;
import com.javarush.textquest.ostapenko.model.QuestService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="QuestsListServlet", value="/quests")
public class QuestsListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IQuestService qs = QuestService.getInstance();
        QuestListResponse questListResponse = qs.getAllQuests(0,3);
        req.setAttribute("questListResponse",questListResponse);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/quests.jsp");
        dispatcher.forward(req,resp);
    }
}
