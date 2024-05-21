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

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
