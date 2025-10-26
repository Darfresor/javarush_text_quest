package com.javarush.textquest.ostapenko.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestCard {
    private Long id;
    private String description;
    @JsonProperty("new")
    private boolean isNew;
    private String imgUrl;

    public QuestCard() {
    }

    public QuestCard(Long id, String description, boolean isNew, String imgUrl) {
        this.id = id;
        this.description = description;
        this.isNew = isNew;
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "QuestCard{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isNew=" + isNew +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isNew() {
        return isNew;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
