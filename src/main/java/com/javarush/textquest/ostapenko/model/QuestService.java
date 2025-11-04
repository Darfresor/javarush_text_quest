package com.javarush.textquest.ostapenko.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javarush.textquest.ostapenko.dto.*;
import com.javarush.textquest.ostapenko.model.entity.Answer;
import com.javarush.textquest.ostapenko.model.entity.QuestCard;
import com.javarush.textquest.ostapenko.model.entity.Question;
import com.javarush.textquest.ostapenko.model.entity.User;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestService {
    private List<QuestCard> quests = new ArrayList<>();
    private List<Question> questions = new ArrayList<>();
    private List<Answer> answers = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    private static final QuestService INSTANCE = new QuestService();

    private QuestService() {
        loadQuests();
        loadQuestions();
        loadAnswers();
        loadUsers();
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

    private void loadUsers() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("data/quests/listUsers.json");

            if (inputStream != null) {
                this.users = mapper.readValue(inputStream,
                        new TypeReference<List<User>>() {
                        });
                System.out.println("Loaded users: " + users.size());
            }
        } catch (Exception e) {
            System.err.println("error load users: " + e.getMessage());
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

    public boolean verifyUser(String userName, String userPass) {
        User searchUser = users.stream()
                .filter(q -> q.getName().equalsIgnoreCase(userName))
                .filter(q -> q.getPassword().equals(userPass))
                .findFirst()
                .orElse(null);
        return (searchUser != null);
    }

    public boolean registerNewUser(String userName, String userPass) {
        User newUser = null;
        User existsUser = users.stream()
                .filter(q -> q.getName().equalsIgnoreCase(userName))
                .findFirst()
                .orElse(null);
        if (existsUser == null) {
            newUser = new User(userName, userPass);
            users.add(newUser);
            saveUserListToJson();
        }
        return (newUser != null);
    }
    private void saveUserListToJson() {
        try {
            ObjectMapper mapper4 = new ObjectMapper();
            mapper4.enable(SerializationFeature.INDENT_OUTPUT);
            URL resource = getClass().getClassLoader().getResource("data/quests/listUsers.json");
            System.out.println(resource);
            mapper4.writerWithDefaultPrettyPrinter().writeValue(new File(resource.getFile()), users);
        } catch(IOException e){
            throw new RuntimeException(e);
        };
    }

    public UserDTO getUserByName(String userName) {
        User user = users.stream()
                .filter(q -> q.getName().equalsIgnoreCase(userName))
                .findFirst()
                .orElse(null);
        return convertToDTO(user);
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

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getName(),
                user.getNumberOfGamesPlayed(),
                user.getUserRoles().stream().map(Enum::name).collect(Collectors.toSet())
        );
    }


}
