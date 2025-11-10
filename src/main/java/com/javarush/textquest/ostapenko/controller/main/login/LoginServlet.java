package com.javarush.textquest.ostapenko.controller.main.login;

import com.javarush.textquest.ostapenko.controller.main.quests.game.StartQuestServlet;
import com.javarush.textquest.ostapenko.dto.UserDTO;
import com.javarush.textquest.ostapenko.model.IQuestService;
import com.javarush.textquest.ostapenko.model.QuestService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name="LoginServlet",value="/login")
public class LoginServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher  = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IQuestService qs = QuestService.getInstance();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        // Получаем данные из формы
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        log.debug("login:   {}", username);
        log.debug("Password =  {}", password);
        boolean isVerify = qs.verifyUser(username,password);
        if(isVerify){
            UserDTO user = qs.getUserByName(username);
            log.debug("user:  {}", user);
            req.getSession().setAttribute("userInfo",user);
            resp.sendRedirect("/personal");
        }else{
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/errorLogin.jsp");
            dispatcher.forward(req, resp);
        }


    }
}
