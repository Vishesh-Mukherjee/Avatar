package com.gdgu.game.entity;

import java.util.List;

public class Avatar {
    private String name;
    private long totalPoint;
    private char rank;
    private List<String> skills;

    public Avatar(String name, long totalPoint, char rank, List<String> skills) {
        this.name = name;
        this.totalPoint = totalPoint;
        this.rank = rank;
        this.skills = skills;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTotalPoint() {
        return this.totalPoint;
    }

    public void setTotalPoint(long totalPoint) {
        this.totalPoint = totalPoint;
    }

    public char getRank() {
        return this.rank;
    }

    public void setRank(char rank) {
        this.rank = rank;
    }

    public List<String> getSkills() {
        return this.skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "{" +
            "name='" + getName() + "'" +
            ", totalPoint='" + getTotalPoint() + "'" +
            ", rank='" + getRank() + "'" +
            ", skills='" + getSkills() + "'" +
            "}";
    }    
}