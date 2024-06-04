package ru.javarush.vasilev.quest.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class SessionStats {
    private String userName = "<blank>";
    private String IP = "<localhost>";
    private Integer wins = 0;
    private Integer loses = 0;

    public void reset(){
        wins = 0;
        loses = 0;
        System.out.println("reset");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
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
