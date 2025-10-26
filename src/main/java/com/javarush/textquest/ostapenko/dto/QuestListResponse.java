package com.javarush.textquest.ostapenko.dto;

import com.javarush.textquest.ostapenko.model.entity.QuestCard;

import java.util.List;

public class QuestListResponse {
    private final List<QuestCard> quests;
    private final int totalPages;
    private final int currentPage;

    public QuestListResponse(List<QuestCard> quests, int totalPages, int currentPage) {
        this.quests = quests;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }
}
