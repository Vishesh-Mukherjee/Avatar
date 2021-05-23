package com.gdgu.game.dao;

import java.util.stream.Stream;

import com.gdgu.game.entity.Gender;
import com.gdgu.game.entity.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CustomerDaoCollImplTest {
    private RegisterDao registerDao;
    private CustomerDao customerDao;

    @BeforeEach
    public void setup() {
        registerDao = new RegisterDaoCollImpl();
        customerDao = new CustomerDaoCollImpl();
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void createAccountTest(long userId, User user, String avatarName) {
        Assertions.assertEquals(userId, registerDao.createAccount(user, "password", avatarName));
    }

    @ParameterizedTest
    @MethodSource("getArguments") 
    public void getUserTest(long userId, User user, String avatarName) {
        registerDao.createAccount(user, "password", avatarName);
        Assertions.assertEquals(user, customerDao.getUser(userId, "password"));
    }

    @ParameterizedTest
    @MethodSource("getArguments") 
    public void getAvatarTest(long userId, User user, String avatarName) {
        registerDao.createAccount(user, "password", avatarName);
        Assertions.assertEquals(avatarName, customerDao.getAvatar(userId, "password").getName());
    }

    @ParameterizedTest
    @MethodSource("getArguments") 
    public void modifyUserTest(long userId, User user, String avatarName) {
        User dummyUser = new User("dummyFirstName", "dummyFirstName", (short)20, Gender.MALE, "0000000000", "dummy@gmail.com");
        registerDao.createAccount(dummyUser, "password", avatarName);
        Assertions.assertEquals(dummyUser, customerDao.getUser(userId, "password"));

        customerDao.modifyUser(userId, "password", user);
        Assertions.assertEquals(user, customerDao.getUser(userId, "password"));
    }

    @ParameterizedTest
    @MethodSource("getArguments")
    public void changePasswordTest(long userId, User user, String avatarName) {
        User dummyUser = new User("dummyFirstName", "dummyLastName", (short)20, Gender.MALE, "0000000000", "dummy@gmail.com");
        registerDao.createAccount(dummyUser, "password", avatarName);
        Assertions.assertEquals(dummyUser, customerDao.getUser(userId, "password"));

        customerDao.changePassword(userId, "password", "newPassword");
        Assertions.assertEquals(dummyUser, customerDao.getUser(userId, "newPassword"));
    }

    @Test
    public void exceptionTest() {
        User d1 = new User("a", "dummyLastName", (short)20, Gender.MALE, "0000000000", "dummy@gmail.com");
        Assertions.assertThrows(RuntimeException.class, () -> registerDao.createAccount(d1, "password", "dummy"));

        User d2 = new User("dummyFirstName", "b", (short)20, Gender.MALE, "0000000000", "dummy@gmail.com");
        Assertions.assertThrows(RuntimeException.class, () -> registerDao.createAccount(d2, "password", "dummy"));

        User d3 = new User("dummyFirstName", "dummyLastName", (short)7, Gender.MALE, "0000000000", "dummy@gmail.com");
        Assertions.assertThrows(RuntimeException.class, () -> registerDao.createAccount(d3, "password", "dummy"));

        User d4 = new User("dummyFirstName", "dummyLastName", (short)20, Gender.MALE, "123456789", "dummy@gmail.com");
        Assertions.assertThrows(RuntimeException.class, () -> registerDao.createAccount(d4, "password", "dummy"));

        User d5 = new User("dummyFirstName", "dummyLastName", (short)20, Gender.MALE, "0000000000", "abcefghij");
        Assertions.assertThrows(RuntimeException.class, () -> registerDao.createAccount(d5, "password", "dummy"));

        User d6 = new User("dummyFirstName", "dummyLastName", (short)20, Gender.MALE, "0000000000", "dummy@gmail.com");
        Assertions.assertThrows(RuntimeException.class, () -> registerDao.createAccount(d6, "pass", "dummy"));

        User d7 = new User("dummyFirstName", "dummyLastName", (short)20, Gender.MALE, "0000000000", "dummy@gmail.com");
        Assertions.assertThrows(RuntimeException.class, () -> registerDao.createAccount(d7, "password", "du"));
    }

    public static Stream<Arguments> getArguments() {
        return Stream.of(
            Arguments.of(1001, new User("Wendy", "Hanson", (short)19, Gender.FEMALE, "3680639355", "wendy@gmail.com"), "Cloud"),  
            Arguments.of(1002, new User("Georgie", "Simmons", (short)20, Gender.MALE, "9375625996", "georgie@gamil.com"), "Aspect"),  
            Arguments.of(1003, new User("Cliff", "Bird", (short)20, Gender.MALE, "4047344392", "cliffbird@hotmail.com"), "O'Doylet"),  
            Arguments.of(1004, new User("Manfred", "Dickkinson", (short)18, Gender.MALE, "1811016145", "Manfred@yahoo.com"), "Reaper"),  
            Arguments.of(1005, new User("Philippa", "Lyons", (short)19, Gender.FEMALE, "1453351347", "lyons@gmail.com"),  "Big Papa"),  
            Arguments.of(1006, new User("Roy", "Holt", (short)21, Gender.MALE, "6813083958", "roy@outlook.com"),  "Slasher")
        );
    }

}
