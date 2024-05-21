package com.aston.automation.model;

public class PayDescriptionData {
    private final String sumTitle = "//*[@class='pay-description__cost']/span";
    private final String payDescriptionText = "//*[@class='payment-page__container']//*[@class='pay-description__text']";
    private final String sumButton = "//*[@class='ng-star-inserted']//button";

    public String getSumTitle() {
        return sumTitle;
    }

    public String getPayDescriptionText() {
        return payDescriptionText;
    }

    public String getSumButton() {
        return sumButton;
    }


    // Поля реквизитов карты
    private final String сardNumber = "//*[@id='cc-number']/following-sibling::label";
    private final String cardPeriod = "//input[contains(@class, 'date-input')]/following-sibling::label";
    private final String cvcCode = "//input[@name='verification_value']/following-sibling::label";
    private final String holderName = "//input[@formcontrolname='holder']/following-sibling::label";

    private final String buttonGpay = "//button[@id='gpay-button-online-api-id']";
    private final String buttonYpay = "//div[@id='yandex-button']";

    public String getСardNumber() {
        return сardNumber;
    }

    public String getCardPeriod() {
        return cardPeriod;
    }

    public String getCvcCode() {
        return cvcCode;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getButtonGpay() {
        return buttonGpay;
    }

    public String getButtonYpay() {
        return buttonYpay;
    }
}
