package com.aston.automation.model;

public class FormsOfPaymentData {

    private final String buttonContinue = "//*[@class='pay-form opened']//button[text()='Продолжить']";

    public String getButtonContinue() {
        return buttonContinue;
    }

    // Поля формы "Услуги связи" (Communication services)

    private final String phoneNumberCS = "//*[@class='pay-form opened']/div/input[@id='connection-phone']";
    private final String sumCS = "//*[@class='pay-form opened']/div/input[@id='connection-sum']";
    private final String emailCS = "//*[@class='pay-form opened']/div/input[@id='connection-email']";

    public String getPhoneNumberCS() {
        return phoneNumberCS;
    }

    public String getSumCS() {
        return sumCS;
    }

    public String getEmailCS() {
        return emailCS;
    }

    // Поля формы "Домашний интернет" (Home Internet)

    private final String subscriberNumberHI = "//*[@class='pay-form opened']/div/input[@id='internet-phone']";
    private final String sumHI = "//*[@class='pay-form opened']/div/input[@id='internet-sum']";
    private final String emailHI = "//*[@class='pay-form opened']/div/input[@id='internet-email']";

    public String getSubscriberNumberHI() {
        return subscriberNumberHI;
    }

    public String getSumHI() {
        return sumHI;
    }

    public String getEmailHI() {
        return emailHI;
    }

    // Поля формы "Рассрочка" (Installment plan)

    private final String accountNumberHI = "//*[@class='pay-form opened']/div/input[@id='score-instalment']";
    private final String sumIP = "//*[@class='pay-form opened']/div/input[@id='instalment-sum']";
    private final String emailIP = "//*[@class='pay-form opened']/div/input[@id='instalment-email']";

    public String getAccountNumberHI() {
        return accountNumberHI;
    }

    public String getSumIP() {
        return sumIP;
    }

    public String getEmailIP() {
        return emailIP;
    }

    // Поля формы "Задолженность" (Debt)

    private final String accountNumberD = "//*[@class='pay-form opened']/div/input[@id='score-arrears']";
    private final String sumD = "//*[@class='pay-form opened']/div/input[@id='arrears-sum']";
    private final String emailD = "//*[@class='pay-form opened']/div/input[@id='arrears-email']";

    public String getAccountNumberD() {
        return accountNumberD;
    }

    public String getSumD() {
        return sumD;
    }

    public String getEmailD() {
        return emailD;
    }

}
