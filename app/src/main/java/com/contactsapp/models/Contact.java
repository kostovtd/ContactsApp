package com.contactsapp.models;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Contact extends RealmObject{

    @PrimaryKey
    private String phoneNumber;

    private String firstName;
    private String lastName;
    private String address;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String phoneNumber, String address) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
