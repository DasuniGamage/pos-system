package com.spring_learning.point_of_sale.dto.request;

import java.util.ArrayList;

public class UpdateContactDTO {
    private int customerId;
    private String customerName;
    private ArrayList<String> contactNumbers;

    public UpdateContactDTO() {
    }

    public UpdateContactDTO(int customerId, String customerName, ArrayList<String> contactNumbers) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contactNumbers = contactNumbers;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<String> getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(ArrayList<String> contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    @Override
    public String toString() {
        return "UpdateContactDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", contactNumbers=" + contactNumbers +
                '}';
    }
}
