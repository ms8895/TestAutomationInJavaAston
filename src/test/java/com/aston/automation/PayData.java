package com.aston.automation;

public class PayData {
    private String typeService;

    private String numberPhone;

    private String replenishmentAmount;

    private String email;

    public PayData(String typeService, String numberPhone, String replenishmentAmount, String email) {
        this.typeService = typeService;
        this.numberPhone = numberPhone;
        this.replenishmentAmount = replenishmentAmount;
        this.email = email;
    }

    public String getTypeService() {
        return typeService;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getReplenishmentAmount() {
        return replenishmentAmount;
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

    public void setReplenishmentAmount(String replenishmentAmount) {
        this.replenishmentAmount = replenishmentAmount;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
