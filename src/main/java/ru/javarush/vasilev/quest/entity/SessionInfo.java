package ru.javarush.vasilev.quest.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class SessionInfo {
    private String userName = "<blank>";
    private Integer wins = 0;
    private Integer loses = 0;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void win(){
        wins++;
    }
    public void lose(){
        loses++;
    }

    public Integer getWins() {
        return wins;
    }

    public Integer getLoses() {
        return loses;
    }
}
