package com.javarush.textquest.ostapenko.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.textquest.ostapenko.dto.QuestCardDTO;
import com.javarush.textquest.ostapenko.dto.QuestListResponse;
import com.javarush.textquest.ostapenko.model.entity.QuestCard;
import com.javarush.textquest.ostapenko.model.entity.Question;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestService {
    private List<QuestCard> quests = new ArrayList<>();
    private List<Question> questions = new ArrayList<>();

    private static final QuestService INSTANCE = new QuestService();

    private QuestService() {
        loadQuests();
        loadQuestions();
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
    private void loadQuestions() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("data/quests/listQuestion.json");

            if (inputStream != null) {
                this.questions = mapper.readValue(inputStream,
                        new TypeReference<List<Question>>() {});
                System.out.println("Loaded question: " + questions.size());
            }
        } catch (Exception e) {
            System.err.println("error load question: " + e.getMessage());
        }
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

    public QuestListResponse getAllQuests(int page, int size) {
        List<QuestCard> allQuests = quests;

        int start = page * size;
        int end = Math.min(start + size, allQuests.size());
        List<QuestCard> pageQuests = allQuests.subList(start, end);


        List<QuestCardDTO> questDTOs = pageQuests.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return new QuestListResponse(
                questDTOs,
                (int) Math.ceil((double) allQuests.size() / size),
                page
        );

    }

    private QuestCardDTO convertToDTO(QuestCard quest) {
        return new QuestCardDTO(
                quest.getId(),
                quest.getDescription(),
                quest.isNew(),
                quest.getImgUrl()
        );
    }

}
