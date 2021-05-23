package com.gdgu.game.dao;

import com.gdgu.game.entity.Avatar;
import com.gdgu.game.entity.User;

public class CustomerDaoCollImpl implements CustomerDao {

    @Override
    public User getUser(long userId, String password) {
        return RegisterDaoCollImpl.getAccountMap()
                               .entrySet()
                               .stream()
                               .filter(x -> x.getKey() == userId && x.getValue().getPassword() == password)
                               .map(x -> x.getValue().getUser())
                               .findFirst()
                               .orElseThrow(RuntimeException::new);
    }

    @Override
    public Avatar getAvatar(long userId, String password) {
        return RegisterDaoCollImpl.getAccountMap()
                               .entrySet()
                               .stream()
                               .filter(x -> x.getKey() == userId && x.getValue().getPassword() == password)
                               .map(x -> x.getValue().getAvatar())
                               .findFirst()
                               .orElseThrow(RuntimeException::new);
    }

    @Override
    public void modifyUser(long userId, String password, User user) {
        RegisterDaoCollImpl.getAccountMap()
                        .entrySet()
                        .stream()
                        .filter(x -> x.getKey() == userId &&  x.getValue().getPassword() == password) 
                        .peek(x -> x.getValue().setUser(user))
                        .findFirst()
                        .orElseThrow(RuntimeException::new);
    }

    @Override
    public void changePassword(long userId, String currentPassword, String newPassword) {
        RegisterDaoCollImpl.getAccountMap()
                        .entrySet()
                        .stream()
                        .filter(x -> x.getKey() == userId && x.getValue().getPassword() == currentPassword)
                        .peek(x -> x.getValue().setPassword(newPassword))
                        .findFirst()
                        .orElseThrow(RuntimeException::new);
    }
    
    
}
