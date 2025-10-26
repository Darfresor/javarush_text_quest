package com.javarush.textquest.ostapenko.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.textquest.ostapenko.model.entity.QuestCard;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class QuestService {
    private List<QuestCard> quests = new ArrayList<>();

    private static final QuestService INSTANCE = new QuestService();

    private QuestService() {
        loadQuests();
    }

    private void loadQuests() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("data/quests/list.json");

            if (inputStream != null) {
                this.quests = mapper.readValue(inputStream,
                        new TypeReference<List<QuestCard>>() {});
                System.out.println("Loaded quests: " + quests.size());
            }
        } catch (Exception e) {
            System.err.println("error load quests: " + e.getMessage());
        }
    }

    public List<QuestCard> getAllQuests() {
        return new ArrayList<>(quests);
    }

    public QuestCard getQuestById(Long id) {
        return quests.stream()
                .filter(q -> q.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static QuestService getInstance() {
        return INSTANCE;
    }
}
