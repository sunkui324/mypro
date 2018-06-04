package com.wolab.model;

public class Champion {

    private  String teamName;

    private User personName;

    public User getPerson() {
        return personName;
    }

    public User getPersonName() {
        return personName;
    }

    public void setPersonName(User personName) {
        this.personName = personName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

}
