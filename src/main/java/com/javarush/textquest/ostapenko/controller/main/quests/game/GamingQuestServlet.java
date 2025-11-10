package com.javarush.textquest.ostapenko.controller.main.quests.game;

import com.javarush.textquest.ostapenko.dto.AnswerDTO;
import com.javarush.textquest.ostapenko.dto.QuestionDTO;
import com.javarush.textquest.ostapenko.dto.UserDTO;
import com.javarush.textquest.ostapenko.model.IQuestService;
import com.javarush.textquest.ostapenko.model.QuestService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GamingQuestServlet", value = "/quests/gaming")
public class GamingQuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IQuestService qs = QuestService.getInstance();
        String answerId = req.getParameter("answer");
        //System.out.println("read param answer = " + answerId);

        AnswerDTO answer = qs.getAnswerById(Long.valueOf(answerId));
        QuestionDTO question = answer.getNextQuestion();
        if (question != null) {
            req.setAttribute("question", question);
            UserDTO user = (UserDTO) req.getSession(false).getAttribute("userInfo");
            if ((question.getWinFlag() || question.getDefeatFlag())
                    && user != null
            ) {
                String userName = user.getName();
                Long newNumberOfGamesPlayed = user.getNumberOfGamesPlayed() + 1;
                qs.updateUserGameCount(userName, newNumberOfGamesPlayed);
                user.setNumberOfGamesPlayed(newNumberOfGamesPlayed);
                req.getSession().setAttribute("userInfo", user);
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/gamingQuests.jsp");
        dispatcher.forward(req, resp);
    }
}
