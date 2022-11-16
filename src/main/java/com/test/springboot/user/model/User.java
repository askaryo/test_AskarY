package com.test.springboot.user.model;

import com.test.springboot.user.exception.FormatException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="Account")
public class User {

    @Id
    private String username;

    private String password;

    private String birthDate;

    private String residenceCountry;

    private String gender;

    private String phoneNumber;

    /**
     *
     * @param username
     * @param password
     * @param birthDate
     * @param residenceCountry
     * @param gender
     * @param phoneNumber
     */
    public User(String username, String password, String birthDate, String residenceCountry, String gender, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.residenceCountry = residenceCountry;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @param username
     * @param password
     * @param birthDate
     * @param residenceCountry
     */
    public User(String username, String password, String birthDate, String residenceCountry) {
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.residenceCountry = residenceCountry;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getResidenceCountry() {
        return residenceCountry;
    }

    public void setResidenceCountry(String residenceCountry) {
        this.residenceCountry = residenceCountry;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        try{
            return Period.between(LocalDate.parse(this.birthDate), LocalDate.now()).getYears();
        }
        catch (Exception e){
            throw new FormatException();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", residenceCountry='" + residenceCountry + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
