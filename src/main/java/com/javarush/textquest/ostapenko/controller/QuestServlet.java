package com.javarush.textquest.ostapenko.controller;

import com.javarush.textquest.ostapenko.dto.UserChoice;
import com.javarush.textquest.ostapenko.model.entity.GameSession;
import com.javarush.textquest.ostapenko.model.entity.QuestStep;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "QuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GameSession gameSession = (GameSession) req.getSession().getAttribute("gameSession");
        String currentStepId = gameSession.getCurrentStep();
        List<QuestStep> questSteps = (List<QuestStep>) req.getSession().getAttribute("questInfo");
        QuestStep currentStep = questSteps.stream()
                .filter(step -> currentStepId.equals(step.getStepId()))
                .findFirst()
                .orElse(null);
        req.getSession().setAttribute("currentStep",currentStep);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/quest.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            StringBuilder sb = new StringBuilder();
            String line;
            try (BufferedReader reader = req.getReader()) {
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
            }
            String jsonBody = sb.toString();
            System.out.println("Получен JSON: " + jsonBody);

            ObjectMapper objectMapper = new ObjectMapper();
            UserChoice userChoice = objectMapper.readValue(jsonBody, UserChoice.class);

            System.out.println("Ответ пользователя: " + userChoice.getAnswer());

        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
