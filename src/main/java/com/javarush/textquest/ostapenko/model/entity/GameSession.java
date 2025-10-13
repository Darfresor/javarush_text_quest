package com.javarush.textquest.ostapenko.model.entity;

public class GameSession {
    private String playerName;
    private int gamesPlayed;
    private String currentStep;

    public GameSession() {
        this.playerName = "not found";
        this.gamesPlayed = 0;
        this.currentStep = "memory_loss";
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public String getCurrentStep() {
        return currentStep;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }
}
