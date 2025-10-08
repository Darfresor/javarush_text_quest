package com.javarush.textquest.ostapenko.model.repository;

import com.javarush.textquest.ostapenko.model.entity.QuestStep;


import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class QuestStepRepository {
    private static final List<QuestStep> storage = new CopyOnWriteArrayList<QuestStep>() {{
        add(new QuestStep(
                2L, "memory_loss", "Внутри космического корабля", "Ты потерял память", "Принять вызов НЛО?",
                Map.of("yes", "Принять вызов", "no", "Отклонить вызов"),
                Map.of("yes", "captain_bridge", "no", "defeat")
        ));
        add(new QuestStep(
                3L, "captain_bridge", "Внутри космического корабля", "Ты принял вызов.", "Поднимаешься на мостик к капитану?",
                Map.of("yes", "Принять вызов", "no", "Отклонить вызов"),
                Map.of("yes", "win", "no", "defeat")
        ));
        add(new QuestStep(
                3L, "defeat", "Внутри космического корабля", "Поражение", "",
                Map.of("", ""),
                Map.of("", "")
        ));
        add(new QuestStep(
                4L, "win", "Внутри космического корабля", "Победа", "",
                Map.of("", ""),
                Map.of("", "")
        ));
    }};
}
