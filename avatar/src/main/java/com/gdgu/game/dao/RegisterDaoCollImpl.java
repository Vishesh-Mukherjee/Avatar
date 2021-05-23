package com.gdgu.game.dao;

import java.util.HashMap;
import java.util.Map;

import com.gdgu.game.entity.Account;
import com.gdgu.game.entity.Avatar;
import com.gdgu.game.entity.User;
import com.gdgu.game.util.GenerateRandom;

public class RegisterDaoCollImpl implements RegisterDao{

    private static long userIdCount;
    private static Map<Long, Account> accountMap;

    public RegisterDaoCollImpl() {
        if (userIdCount == 0) {
            userIdCount = 1001;
            accountMap = new HashMap<Long, Account>();
        }
    }

    @Override
    public long createAccount(User user, String password, String avatarName) {
        validateUser(user);
        validatePassword(password);
        validateAvatarName(avatarName);
        accountMap.put(userIdCount
                       ,new Account(password
                                    ,user
                                    ,createAvatar(avatarName)));
        return userIdCount ++;
    }

    public static Map<Long, Account> getAccountMap() {
        return accountMap;
    }

    private Avatar createAvatar(String avatarName) {
        return new Avatar(avatarName
                          ,1000
                          ,GenerateRandom.rank()
                          ,GenerateRandom.skills());
    }

    private void validateUser(User user) {
        user.validateFirstName();
        user.validateLastName();
        user.validateAge();
        user.validatePhoneNo();
        user.validateEmail();
    }

    private void validatePassword(String password) {
        if (password.length() <= 5) {
            throw new RuntimeException("Password should be greater than 5 characters");
        }
    } 

    private void validateAvatarName(String avatarName) {
        if (avatarName.length() < 3) {
            throw new RuntimeException("Avatar name should not be less than 3 characters");
        }
    }
}
