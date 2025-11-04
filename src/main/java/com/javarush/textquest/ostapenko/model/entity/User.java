package com.javarush.textquest.ostapenko.model.entity;


import java.util.HashSet;
import java.util.Set;

public class User {
    String name;
    String password;
    Long numberOfGamesPlayed;
    Set<UserRoles> userRoles;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.numberOfGamesPlayed = 0L;
        setDefaultRole();

    }

    public User(String name, String password, Long numberOfGamesPlayed) {
        this.name = name;
        this.password = password;
        this.numberOfGamesPlayed = numberOfGamesPlayed;
        setDefaultRole();

    }

    private void setDefaultRole(){
        Set<UserRoles> userRoles = new HashSet<>();
        userRoles.add(UserRoles.BASE);
        this.userRoles = userRoles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumberOfGamesPlayed(Long numberOfGamesPlayed) {
        this.numberOfGamesPlayed = numberOfGamesPlayed;
    }

    public Set<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Long getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", numberOfGamesPlayed=" + numberOfGamesPlayed +
                ", userRoles=" + userRoles +
                '}';
    }
}
