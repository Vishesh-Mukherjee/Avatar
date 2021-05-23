package com.gdgu.game.entity;

public class Account {
    private String password;
    private User user;
    private Avatar avatar;


    public Account(String password, User user, Avatar avatar) {
        this.password = password;
        this.user = user;
        this.avatar = avatar;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Avatar getAvatar() {
        return this.avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "{" +
            " password='" + getPassword() + "'" +
            ", user='" + getUser() + "'" +
            ", avatar='" + getAvatar() + "'" +
            "}";
    }

}
