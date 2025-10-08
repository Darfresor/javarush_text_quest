package com.javarush.textquest.ostapenko.model.entity;

import java.util.Map;

public class QuestStep {
    private final Long id;
    private final String stepId;
    private final String title;
    private final String description;
    private final String question;

    private Map<String, String> choices;
    private Map<String, String> nextSteps;

    public QuestStep(Long id, String stepId, String title, String description, String question,
                     Map<String, String> choices, Map<String, String> nextSteps) {
        this.id = id;
        this.stepId = stepId;
        this.title = title;
        this.description = description;
        this.question = question;
        this.choices = choices;
        this.nextSteps = nextSteps;
    }
}
