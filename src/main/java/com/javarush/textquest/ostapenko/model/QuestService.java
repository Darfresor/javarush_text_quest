package com.javarush.textquest.ostapenko.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.textquest.ostapenko.dto.AnswerDTO;
import com.javarush.textquest.ostapenko.dto.QuestCardDTO;
import com.javarush.textquest.ostapenko.dto.QuestListResponse;
import com.javarush.textquest.ostapenko.dto.QuestionDTO;
import com.javarush.textquest.ostapenko.model.entity.Answer;
import com.javarush.textquest.ostapenko.model.entity.QuestCard;
import com.javarush.textquest.ostapenko.model.entity.Question;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestService {
    private List<QuestCard> quests = new ArrayList<>();
    private List<Question> questions = new ArrayList<>();
    private List<Answer> answers = new ArrayList<>();

    private static final QuestService INSTANCE = new QuestService();

    private QuestService() {
        loadQuests();
        loadQuestions();
        loadAnswers();
    }

    private void loadQuests() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("data/quests/listCard.json");

            if (inputStream != null) {
                this.quests = mapper.readValue(inputStream,
                        new TypeReference<List<QuestCard>>() {
                        });
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
                        new TypeReference<List<Question>>() {
                        });
                System.out.println("Loaded question: " + questions.size());
            }
        } catch (Exception e) {
            System.err.println("error load question: " + e.getMessage());
        }
    }
    private void loadAnswers() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("data/quests/listAnswer.json");

            if (inputStream != null) {
                this.answers = mapper.readValue(inputStream,
                        new TypeReference<List<Answer>>() {
                        });
                System.out.println("Loaded answer: " + answers.size());
            }
        } catch (Exception e) {
            System.err.println("error load answer: " + e.getMessage());
        }
    }

    public QuestCardDTO getQuestById(Long id) {
        QuestCard currentQuest = quests.stream()
                .filter(q -> q.getId().equals(id))
                .findFirst()
                .orElse(null);
        return convertToDTO(currentQuest);
    }

    public AnswerDTO getAnswerById(Long id) {
        Answer currentAnswer = answers.stream()
                .filter(q -> q.getId().equals(id))
                .findFirst()
                .orElse(null);
        return convertToDTO(currentAnswer);
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
                quest.getImgUrl(),
                quest.getStartQuestion() != null ? convertToDTO(quest.getStartQuestion()) : null
        );
    }

    private QuestionDTO convertToDTO(Question question) {
        if (question == null) {
            return null;
        }
        return new QuestionDTO(
                question.getId(),
                question.getDescription(),
                question.getQuestion(),
                question.getImgUrl(),
                question.getAnswers() != null ? convertToDTO(question.getAnswers()) : new ArrayList<>(),
                question.getDefeatFlag(),
                question.getWinFlag()
        );
    }
    private AnswerDTO convertToDTO(Answer answer) {
        if (answer == null) {
            return null;
        }
        return new AnswerDTO(
                answer.getId(),
                answer.getDescription(),
                answer.getNextQuestion() != null ? convertToDTO(answer.getNextQuestion()) : null
        );
    }
    private List<AnswerDTO> convertToDTO(List<Answer> answers) {
        if (answers == null) {
            return new ArrayList<>();
        }
        List<AnswerDTO> list = new ArrayList<>();
        for (Answer answer : answers) {
            list.add(convertToDTO(answer));
        }
        return list;
    }

}
