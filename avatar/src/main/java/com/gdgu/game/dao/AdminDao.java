package com.gdgu.game.dao;

import java.util.Map;

import com.gdgu.game.entity.Avatar;
import com.gdgu.game.entity.User;

public interface AdminDao {
    Map<Long, User> getAllUserMap();
    Map<Long, Avatar> getAllAvatarMap();
    void modifyAvatar(long userId, Avatar avatar);
    Map<Character, Long> getAllRankCountMap();
    Map<Long, Long> getLeaderBoard();
    void modifyTotalPoint(long userId, long totalPoint);
}
