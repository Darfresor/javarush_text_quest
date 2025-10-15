package com.javarush.textquest.ostapenko.model;

import com.javarush.textquest.ostapenko.model.constants.Introduction;
import com.javarush.textquest.ostapenko.model.entity.GameSession;
import com.javarush.textquest.ostapenko.model.entity.QuestStep;
import com.javarush.textquest.ostapenko.model.repository.QuestStepRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestService implements IQuestService{
    private Introduction introduction;
    private GameSession gameSession;
    private QuestStepRepository questStepRepository;

    public QuestService() {
        this.introduction = new Introduction();
        this.gameSession = new GameSession();
        this.questStepRepository = new QuestStepRepository();
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
    public List<QuestStep> getQuestData(){
        return QuestStepRepository.getQuestData();
    }
}
