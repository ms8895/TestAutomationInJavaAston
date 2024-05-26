package com.aston.automation.model;

public class PayData {
    private String typeService;

    private String numberPhone;

    private String amount;

    private String email;

    public PayData(String typeService, String numberPhone, String amount, String email) {
        this.typeService = typeService;
        this.numberPhone = numberPhone;
        this.amount = amount;
        this.email = email;
    }

    public PayData(String typeService) {
        this.typeService = typeService;
    }

    public String getTypeService() {
        return typeService;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getAmount() {
        return amount;
    }

    public String getEmail() {
        return email;
    }

    public String getFormName() {
        switch (typeService) {
            case "Услуги связи":
                return "pay-connection";
            case "Домашний интернет":
                return "pay-internet";
            case "Рассрочка":
                return "pay-instalment";
            case "Задолженность":
                return "pay-arrears";
            default:
                System.out.println("Неизвестная форма: " + typeService);
                return "unknown";
        }
    }
}
