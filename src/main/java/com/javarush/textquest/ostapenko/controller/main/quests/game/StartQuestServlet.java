package com.javarush.textquest.ostapenko.controller.main.quests.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.textquest.ostapenko.dto.AnswerDTO;
import com.javarush.textquest.ostapenko.dto.QuestCardDTO;
import com.javarush.textquest.ostapenko.dto.QuestionDTO;
import com.javarush.textquest.ostapenko.dto.UserChoice;
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
        //System.out.println("read param id = "+ textId);
        req.getSession().setAttribute("questId",textId);

        QuestCardDTO questCard = qs.getQuestById(Long.valueOf(textId));
        QuestionDTO startQuestion = questCard.getStartQuestion();
        //System.out.println(startQuestion.getDescription());
        //System.out.println(startQuestion.getQuestion());

        req.setAttribute("startQuestion",startQuestion);

        RequestDispatcher dispatcher  = req.getRequestDispatcher("/WEB-INF/views/startQuests.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestService qs = QuestService.getInstance();

        ObjectMapper mapper = new ObjectMapper();
        UserChoice userChoice = mapper.readValue(req.getReader(), UserChoice.class);
        System.out.println(userChoice.getId());

        AnswerDTO answer = qs.getAnswerById(userChoice.getId());
        QuestionDTO question = answer.getNextQuestion();
        System.out.println(question);
    }
}
