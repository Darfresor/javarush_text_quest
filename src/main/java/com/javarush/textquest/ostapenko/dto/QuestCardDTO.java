package com.javarush.textquest.ostapenko.dto;


public class QuestCardDTO {
    private Long id;
    private String description;
    private boolean isNew;
    private String imgUrl;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsNew() {
        return isNew;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public QuestCardDTO(Long id, String description, boolean isNew, String imgUrl) {
        this.id = id;
        this.description = description;
        this.isNew = isNew;
        this.imgUrl = imgUrl;
    }
}
