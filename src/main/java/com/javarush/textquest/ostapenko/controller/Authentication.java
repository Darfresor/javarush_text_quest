package com.javarush.textquest.ostapenko.controller;

import com.javarush.textquest.ostapenko.dto.AnswerDTO;
import com.javarush.textquest.ostapenko.dto.QuestionDTO;
import com.javarush.textquest.ostapenko.model.QuestService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="Authentication",value="/authentication")
public class Authentication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestService qs = QuestService.getInstance();
        RequestDispatcher dispatcher  = req.getRequestDispatcher("/WEB-INF/views/authentication.jsp");
        dispatcher.forward(req, resp);
    }
}
