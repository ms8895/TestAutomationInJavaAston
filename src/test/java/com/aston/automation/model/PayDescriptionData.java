package com.aston.automation.model;

public class PayDescriptionData {
    private final String sumTitle = "//*[@class='pay-description__cost']/span";
    private final String payDescriptionText = "//*[@class='pay-description__cost']/following-sibling::span";
    private final String sumButton = "//*[@class='card-page__card']//button[@type='submit']";

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
    private final String cardNumber = "//*[@id='cc-number']/following-sibling::label";
    private final String cardPeriod = "//input[contains(@class, 'date-input')]/following-sibling::label";
    private final String cvcCode = "//input[@name='verification_value']/following-sibling::label";
    private final String holderName = "//input[@formcontrolname='holder']/following-sibling::label";
    // Поля реквизитов карты

    private final String buttonGpay = "//button[@id='gpay-button-online-api-id']";
    private final String buttonYpay = "//div[@id='yandex-button']";

    public String getCardNumber() {
        return cardNumber;
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
