package com.javarush.textquest.ostapenko.controller;

import com.javarush.textquest.ostapenko.model.Quest2Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet(name = "initServlet", value = "/header.jsp")
public class InitServlet extends HttpServlet {
    private Quest2Service quest2Service;

    @Override
    public void init() throws ServletException {
        quest2Service = new Quest2Service();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("startPageData", quest2Service.getStartPageData());
        req.getSession().setAttribute("gameSession", quest2Service.getGameSession());
        req.getSession().setAttribute("questInfo", quest2Service.getQuestData());
        resp.sendRedirect(req.getContextPath()+"/start");
    }
}
