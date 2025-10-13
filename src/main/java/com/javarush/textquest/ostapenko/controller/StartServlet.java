package com.javarush.textquest.ostapenko.controller;

import com.javarush.textquest.ostapenko.model.entity.GameSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "startServlet",value="/start")
public class StartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/createPlayer.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerName = req.getParameter("playerName");
        System.out.println(playerName);
        GameSession gameSession = (GameSession) req.getSession().getAttribute("gameSession");
        gameSession.setPlayerName(playerName);
        req.setAttribute("gameSession",gameSession);
    }
}
