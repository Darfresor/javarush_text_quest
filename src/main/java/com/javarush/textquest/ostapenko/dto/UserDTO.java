package com.javarush.textquest.ostapenko.dto;

import java.util.Set;

public class UserDTO {
    String name;
    Long numberOfGamesPlayed;
    Set<String> userRoles;

    public UserDTO(String name,  Long numberOfGamesPlayed, Set<String> userRoles) {
        this.name = name;
        this.numberOfGamesPlayed = numberOfGamesPlayed;
        this.userRoles = userRoles;
    }

    public String getName() {
        return name;
    }


    public Long getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    public Set<String> getUserRoles() {
        return userRoles;
    }
}
