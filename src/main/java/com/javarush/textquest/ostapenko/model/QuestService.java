package com.javarush.textquest.ostapenko.model;

import com.javarush.textquest.ostapenko.model.constants.Introduction;
import com.javarush.textquest.ostapenko.model.entity.GameSession;

import java.util.HashMap;
import java.util.Map;

public class QuestService implements IQuestService{
    private Introduction introduction;
    private GameSession gameSession;

    public QuestService() {
        this.introduction = new Introduction();
        this.gameSession = new GameSession();
    }

    @Override
    public Map<String, String> getStartPageData() {
        Map<String, String> data = new HashMap<>();
        data.put("annotation",introduction.getAnnotaionText());
        data.put("meeting_player_info",introduction.getMettingThePlayerText());
        return data;
    }
    public GameSession getGameSession(){
        return gameSession;
    }
}
