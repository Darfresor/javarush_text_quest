package com.javarush.textquest.ostapenko.dto;

import com.javarush.textquest.ostapenko.model.entity.QuestCard;

import java.util.List;

public class QuestListResponse {
    private final List<QuestCardDTO> quests;
    private final int totalPages;
    private final int currentPage;

    public QuestListResponse(List<QuestCardDTO> quests, int totalPages, int currentPage) {
        this.quests = quests;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }

    public List<QuestCardDTO> getQuests() {
        return quests;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }
}
