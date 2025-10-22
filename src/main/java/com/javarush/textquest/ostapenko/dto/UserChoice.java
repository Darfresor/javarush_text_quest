package com.javarush.textquest.ostapenko.dto;

public class UserChoice {
    private String answer;

    // Обязательно нужен конструктор по умолчанию
    public UserChoice() {}

    public UserChoice(String answer) {
        this.answer = answer;
    }

    // Геттеры и сеттеры
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}