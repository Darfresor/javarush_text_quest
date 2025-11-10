package com.javarush.textquest.ostapenko.controller.init;

import com.javarush.textquest.ostapenko.model.IQuestService;
import com.javarush.textquest.ostapenko.model.QuestService;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

@WebListener
public class ContextListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(ContextListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        IQuestService questService = QuestService.getInstance();
        logger.info("QuestService initialize with start application");
        logger.info("Current working directory: " + new File(".").getAbsolutePath());
        logger.info("User directory: " + System.getProperty("user.dir"));
    }
}
