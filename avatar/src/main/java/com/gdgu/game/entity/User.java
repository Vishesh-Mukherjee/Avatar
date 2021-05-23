package com.gdgu.game.entity;

public class User {

    private String firstName;
    private String lastName;
    private short age;
    private Gender gender;
    private String phoneNo;
    private String email;


    public User(String firstName, String lastName, short age, Gender gender, String phoneNo, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public short getAge() {
        return this.age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void validateFirstName() {
        if (this.firstName.length() < 3) {
            throw new RuntimeException("First name cannot be less than 3 characters");
        }
    }

    public void validateLastName() {
        if (this.lastName.length() < 3) {
            throw new RuntimeException("Last name cannot be less than 3 characters");
        }
    }

    public void validateAge() {
        if (this.age <= 8) {
            throw new RuntimeException("Age should be greater than 8");
        }
    }

    public void validatePhoneNo() {
        if (this.phoneNo.length() != 10) {
            throw new RuntimeException("Phone number should be 10 digit long");
        }
        if (this.phoneNo.matches("//d+")) {
            throw new RuntimeException("Phone number should contain only digits");
        }
    }

    public void validateEmail() {
        if (!this.email.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
            throw new RuntimeException("Invalid email");
        }
    }

    @Override
    public String toString() {
        return "{" +
            "firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", age='" + getAge() + "'" +
            ", gender='" + getGender() + "'" +
            ", phoneNo='" + getPhoneNo() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }

}