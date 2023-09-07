package ru.netology.bdd.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.bdd.data.DataHelper;


import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private final SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private final SelenideElement amountInput = $("[data-test-id='amount'] input");
    private final SelenideElement fromInput = $("[data-test-id='from'] input");
    private final SelenideElement transferHeading = $(byText("Пополнение карты"));
    private final SelenideElement errorMessage = $("[data-test-id='error-notification']");

    public TransferPage(){
        transferHeading.shouldBe(visible);
    }

    public DashboardPage makeTransfer(String amountToTransfer, String CardNumber) {
        amountInput.setValue(amountToTransfer);
        fromInput.setValue(CardNumber);
        transferButton.click();
        return new DashboardPage();
    }
}