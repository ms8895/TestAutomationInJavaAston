package com.aston.automation.model;

public class FormsOfPaymentData {

    public String getButtonContinue(String formName) {
        return String.format("//form[@id='%s']//button[@type='submit']", formName);
    }

    // Поля формы "Услуги связи" (Communication services)

    private final String phoneNumberCS = "//*[@id='connection-phone']";
    private final String sumCS = "//*[@id='connection-sum']";
    private final String emailCS = "//*[@id='connection-email']";

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

    private final String subscriberNumberHI = "//*[@id='internet-phone']";
    private final String sumHI = "//*[@id='internet-sum']";
    private final String emailHI = "//*[@id='internet-email']";

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

    private final String accountNumberIP = "//*[@id='score-instalment']";
    private final String sumIP = "//*[@id='instalment-sum']";
    private final String emailIP = "//*[@id='instalment-email']";

    public String getAccountNumberIP() {
        return accountNumberIP;
    }

    public String getSumIP() {
        return sumIP;
    }

    public String getEmailIP() {
        return emailIP;
    }

    // Поля формы "Задолженность" (Debt)

    private final String accountNumberD = "//*[@id='score-arrears']";
    private final String sumD = "//*[@id='arrears-sum']";
    private final String emailD = "//*[@id='arrears-email']";

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
