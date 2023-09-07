package ru.netology.bdd.steps;

import io.cucumber.java.ru.*;
import ru.netology.bdd.data.DataHelper;
import ru.netology.bdd.page.DashboardPage;
import ru.netology.bdd.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TemplateSteps  {
    private DashboardPage dashboardPage;


    @Пусть("Пользователь залогинен с именем {string} и паролем {string}")
    public void loggingWithNameAndPassword(String login, String password) {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var verificationPage = loginPage.validLogin(login, password);
        dashboardPage = verificationPage.validVerify(DataHelper.getVerificationCode());
    }

    @Когда("Пользователь переводит {string} рублей с карты с номером {string} на свою {int} карту")
    public void makeTransferToFirstCard(String amount, String secondCardNumber, int firstCardNumber) {
        var transferPage = dashboardPage.selectCardToTransfer(firstCardNumber);
        dashboardPage = transferPage.makeTransfer(amount, secondCardNumber);
    }
    @Тогда("Баланс его {int} карты из списка на главной странице должен стать {int} рублей")
    public void verifyFirstCardBalance(int firstCardNumber, int expectedBalanceFirstCard) {
        var actualBalanceFirstCard = dashboardPage.getCardBalance(firstCardNumber);
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
    }

}
