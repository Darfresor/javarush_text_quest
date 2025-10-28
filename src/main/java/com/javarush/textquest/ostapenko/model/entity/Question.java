package com.javarush.textquest.ostapenko.model.entity;

import java.util.List;

public class Question {
    private Long id;
    private String description;
    private String question;
    private String imgUrl;
    private List<Answer> answers;
    private boolean defeatFlag = false;
    private boolean winFlag = false;

    public Question() {
    }

    public Question(Long id, String description, String question, String imgUrl) {
        this.id = id;
        this.description = description;
        this.question = question;
        this.imgUrl = imgUrl;
    }

    public String getQuestion() {
        return question;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public boolean isDefeatFlag() {
        return defeatFlag;
    }

    public boolean isWinFlag() {
        return winFlag;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public boolean getDefeatFlag() {
        return defeatFlag;
    }

    public void setDefeatFlag(boolean defeatFlag) {
        this.defeatFlag = defeatFlag;
    }

    public boolean getWinFlag() {
        return winFlag;
    }

    public void setWinFlag(boolean winFlag) {
        this.winFlag = winFlag;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", question='" + question + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", answers=" + answers +
                ", defeatFlag=" + defeatFlag +
                ", winFlag=" + winFlag +
                '}';
    }
}
