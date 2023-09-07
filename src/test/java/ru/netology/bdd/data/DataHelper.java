package ru.netology.bdd.data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
    private DataHelper(){
    }
    public static VerificationCode getVerificationCode(){
        return new VerificationCode("12345");
    }

    @Value
    public static class VerificationCode {
        String code;
    }
    @Value
    public static class CardInfo {
        String cardNumber;
        String testId;
    }
    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
}
