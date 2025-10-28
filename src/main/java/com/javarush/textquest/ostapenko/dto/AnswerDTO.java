package com.javarush.textquest.ostapenko.dto;

import com.javarush.textquest.ostapenko.model.entity.Question;

public class AnswerDTO {
    private Long id;
    private String description;
    private QuestionDTO nextQuestion;

    public AnswerDTO(Long id, String description, QuestionDTO nextQuestion) {
        this.id = id;
        this.description = description;
        this.nextQuestion = nextQuestion;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public QuestionDTO getNextQuestion() {
        return nextQuestion;
    }
}
