package com.javarush.textquest.ostapenko.model.entity;

public class Answer {
    private Long id;
    private String description;
    private Question nextQuestion;

    public Answer() {
    }

    public Answer(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Question getNextQuestion() {
        return nextQuestion;
    }

    public void setNextQuestion(Question nextQuestion) {
        this.nextQuestion = nextQuestion;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", nextQuestion=" + nextQuestion +
                '}';
    }
}
