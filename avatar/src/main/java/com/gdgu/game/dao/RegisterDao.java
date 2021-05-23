package com.gdgu.game.dao;

import com.gdgu.game.entity.User;

public interface RegisterDao {
    long createAccount(User user, String password, String avatarName);
}
