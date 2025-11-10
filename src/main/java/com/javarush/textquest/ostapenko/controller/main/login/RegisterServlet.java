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

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(RegisterServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/register.jsp");
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
        String email = req.getParameter("email");

        log.debug("login:   {}", username);
        log.debug("Password :  {}", password);
        log.debug("email:  {}", email);
        boolean isCreateUser = qs.registerNewUser(username,password);
        if(isCreateUser){
            UserDTO user = qs.getUserByName(username);
            log.debug("user:  {}", user);
            req.getSession().setAttribute("userInfo",user);
            resp.sendRedirect("/personal");
        }else{
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/errorRegister.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
