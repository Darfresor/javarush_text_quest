package com.javarush.textquest.ostapenko.controller.init;

import com.javarush.textquest.ostapenko.model.QuestService;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        QuestService questService = QuestService.getInstance();
        //System.out.println("QuestService initialize with start application");
    }
}
