package com.gdgu.game.dao;

import java.util.LinkedHashMap;
import java.util.Map;

import com.gdgu.game.entity.Avatar;
import com.gdgu.game.entity.Gender;
import com.gdgu.game.entity.User;
import com.gdgu.game.util.GenerateRandom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdminDaoCollImplTest {

    private RegisterDao registerDao;
    private CustomerDao customerDao;
    private AdminDao adminDao;

    @BeforeEach
    public void setup() {
        registerDao = new RegisterDaoCollImpl();
        customerDao = new CustomerDaoCollImpl();
        adminDao = new AdminDaoCollImpl();
    }

    @Test
    public void getAllUserMapTest() {
        Assertions.assertTrue(adminDao.getAllUserMap().isEmpty());

        registerDao.createAccount(new User("Wendy", "Hanson", (short)19, Gender.FEMALE, "3680639355", "wendy@gmail.com"), "password", "Cloud");
        registerDao.createAccount(new User("Georgie", "Simmons", (short)20, Gender.MALE, "9375625996", "georgie@gamil.com"), "password", "Aspect");
        registerDao.createAccount(new User("Cliff", "Bird", (short)20, Gender.MALE, "4047344392", "cliffbird@hotmail.com"), "password", "O'Doylet");

        Assertions.assertEquals(3, adminDao.getAllUserMap().size());
    }

    @Test
    public void getAllAvatarMapTest() {
        Assertions.assertTrue(adminDao.getAllAvatarMap().isEmpty());

        registerDao.createAccount(new User("Wendy", "Hanson", (short)19, Gender.FEMALE, "3680639355", "wendy@gmail.com"), "password", "Cloud");
        registerDao.createAccount(new User("Georgie", "Simmons", (short)20, Gender.MALE, "9375625996", "georgie@gamil.com"), "password", "Aspect");
        registerDao.createAccount(new User("Cliff", "Bird", (short)20, Gender.MALE, "4047344392", "cliffbird@hotmail.com"), "password", "O'Doylet");
    
        Assertions.assertEquals(3, adminDao.getAllAvatarMap().size());
    }

    @Test
    public void modifyAvatarTest() {
        registerDao.createAccount(new User("Wendy", "Hanson", (short)19, Gender.FEMALE, "3680639355", "wendy@gmail.com"), "password", "Cloud");
        Assertions.assertEquals("Cloud", customerDao.getAvatar(1001, "password").getName());
        adminDao.modifyAvatar(1001, new Avatar("ThunderCloud", 5432, 'A', GenerateRandom.skills()));
        Assertions.assertEquals("ThunderCloud", customerDao.getAvatar(1001, "password").getName());
    }

    @Test
    public void modifyTotalPointTest() {
        registerDao.createAccount(new User("Wendy", "Hanson", (short)19, Gender.FEMALE, "3680639355", "wendy@gmail.com"), "password", "Cloud");
        registerDao.createAccount(new User("Georgie", "Simmons", (short)20, Gender.MALE, "9375625996", "georgie@gamil.com"), "password", "Aspect");
        registerDao.createAccount(new User("Cliff", "Bird", (short)20, Gender.MALE, "4047344392", "cliffbird@hotmail.com"), "password", "O'Doylet");

        adminDao.modifyTotalPoint(1001, 4321);        
        adminDao.modifyTotalPoint(1002, 6543);        
        adminDao.modifyTotalPoint(1003, 3241);        

        Assertions.assertEquals(4321, customerDao.getAvatar(1001, "password").getTotalPoint());
        Assertions.assertEquals(6543, customerDao.getAvatar(1002, "password").getTotalPoint());
        Assertions.assertEquals(3241, customerDao.getAvatar(1003, "password").getTotalPoint());
    }

    @Test
    public void getLeaderBoardTest() {
        Assertions.assertTrue(adminDao.getLeaderBoard().isEmpty());

        registerDao.createAccount(new User("Wendy", "Hanson", (short)19, Gender.FEMALE, "3680639355", "wendy@gmail.com"), "password", "Cloud");
        registerDao.createAccount(new User("Georgie", "Simmons", (short)20, Gender.MALE, "9375625996", "georgie@gamil.com"), "password", "Aspect");
        registerDao.createAccount(new User("Cliff", "Bird", (short)20, Gender.MALE, "4047344392", "cliffbird@hotmail.com"), "password", "O'Doylet");

        adminDao.modifyTotalPoint(1001, 4321);        
        adminDao.modifyTotalPoint(1002, 6543);        
        adminDao.modifyTotalPoint(1003, 3241);    

        Map<Long, Long> expectedMap = new LinkedHashMap<Long, Long>();
        expectedMap.put(1002L, 6543L);
        expectedMap.put(1001L, 4321L);
        expectedMap.put(1003L, 3241L);

        Assertions.assertEquals(expectedMap, adminDao.getLeaderBoard());

    }

}
