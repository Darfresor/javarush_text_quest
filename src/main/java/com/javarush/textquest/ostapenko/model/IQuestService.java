package com.javarush.textquest.ostapenko.model;

import com.javarush.textquest.ostapenko.dto.AnswerDTO;
import com.javarush.textquest.ostapenko.dto.QuestCardDTO;
import com.javarush.textquest.ostapenko.dto.QuestListResponse;
import com.javarush.textquest.ostapenko.dto.UserDTO;

public interface IQuestService {
    QuestCardDTO getQuestById(Long id);

    AnswerDTO getAnswerById(Long id);

    boolean verifyUser(String userName, String userPass);

    boolean registerNewUser(String userName, String userPass);

    void updateUserGameCount(String userName, Long numberOfGamesPlayed);

    UserDTO getUserByName(String userName);

    QuestListResponse getAllQuests(int page, int size);

}
