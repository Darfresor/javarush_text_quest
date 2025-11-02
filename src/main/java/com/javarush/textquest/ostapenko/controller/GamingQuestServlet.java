package com.javarush.textquest.ostapenko.controller;

import com.javarush.textquest.ostapenko.dto.AnswerDTO;
import com.javarush.textquest.ostapenko.dto.QuestCardDTO;
import com.javarush.textquest.ostapenko.dto.QuestionDTO;
import com.javarush.textquest.ostapenko.model.QuestService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="GamingQuestServlet", value="/quests/gaming")
public class GamingQuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestService qs = QuestService.getInstance();
        String answerId = req.getParameter("answer");
        System.out.println("read param answer = "+ answerId);

        AnswerDTO answer = qs.getAnswerById(Long.valueOf(answerId));
        QuestionDTO question = answer.getNextQuestion();

        req.setAttribute("question",question);
        RequestDispatcher dispatcher  = req.getRequestDispatcher("/WEB-INF/views/gamingQuests.jsp");
        dispatcher.forward(req, resp);
    }
}
