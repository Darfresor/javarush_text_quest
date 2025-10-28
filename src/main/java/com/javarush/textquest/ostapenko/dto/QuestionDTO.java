package com.javarush.textquest.ostapenko.dto;

import com.javarush.textquest.ostapenko.model.entity.Answer;

import java.util.List;

public class QuestionDTO {
    private Long id;
    private String description;
    private String question;
    private String imgUrl;
    private List<AnswerDTO> answers;
    private boolean defeatFlag = false;
    private boolean winFlag = false;

    public QuestionDTO(Long id, String description, String question, String imgUrl, List<AnswerDTO> answers, boolean defeatFlag, boolean winFlag) {
        this.id = id;
        this.description = description;
        this.question = question;
        this.imgUrl = imgUrl;
        this.answers = answers;
        this.defeatFlag = defeatFlag;
        this.winFlag = winFlag;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getQuestion() {
        return question;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public boolean getDefeatFlag() {
        return defeatFlag;
    }

    public boolean getWinFlag() {
        return winFlag;
    }
}
