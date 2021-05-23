package com.gdgu.game.dao;

import com.gdgu.game.entity.Avatar;
import com.gdgu.game.entity.User;

public interface CustomerDao {
    User getUser(long userId, String password);
    Avatar getAvatar(long userId, String password);
    void modifyUser(long userId, String password, User user);
    void changePassword(long userId, String currentPassword, String newPassword);
}
