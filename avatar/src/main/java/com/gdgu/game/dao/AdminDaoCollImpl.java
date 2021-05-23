package com.gdgu.game.dao;

import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.LinkedHashMap;

import com.gdgu.game.entity.Avatar;
import com.gdgu.game.entity.User;

public class AdminDaoCollImpl implements AdminDao{

    @Override
    public Map<Long, User> getAllUserMap() {
        return RegisterDaoCollImpl.getAccountMap()
                        .entrySet()
                        .stream()
                        .collect(toMap(Entry::getKey, x -> x.getValue().getUser()));
    }

    @Override
    public Map<Long, Avatar> getAllAvatarMap() {
        return RegisterDaoCollImpl.getAccountMap()
                               .entrySet()
                               .stream()
                               .collect(toMap(Entry::getKey, x -> x.getValue().getAvatar()));
    }

    @Override
    public void modifyAvatar(long userId, Avatar avatar) {
        RegisterDaoCollImpl.getAccountMap()
                .entrySet()
                .stream()
                .filter(x -> x.getKey() == userId)
                .peek(x -> x.getValue().setAvatar(avatar))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Map<Character, Long> getAllRankCountMap() {
        return RegisterDaoCollImpl.getAccountMap()
                                  .entrySet()
                                  .stream()
                                  .collect(groupingBy(x -> x.getValue().getAvatar().getRank(), counting()));
    }

    @Override
    public Map<Long, Long> getLeaderBoard() {
        return RegisterDaoCollImpl.getAccountMap()
                                  .entrySet()
                                  .stream()
                                  .collect(toMap(Entry::getKey, x -> x.getValue().getAvatar().getTotalPoint()))
                                  .entrySet()
                                  .stream()
                                  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                  .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> x, LinkedHashMap::new));
    }

    @Override
    public void modifyTotalPoint(long userId, long totalPoint) {
        RegisterDaoCollImpl.getAccountMap()
                           .entrySet()
                           .stream()
                           .filter(x -> x.getKey() == userId)
                           .peek(x -> x.getValue().getAvatar().setTotalPoint(totalPoint))
                           .findFirst()
                           .orElseThrow(RuntimeException::new);
    }

}
