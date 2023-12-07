package com.example.gcccylclingmobileapplication;

import java.net.URL;

public class CyclingClubAccount extends Account {

    public int phoneNumber;
    public String mainContact;
    public URL socialMediaLink;

    final String role = "Cycling Club";
    public CyclingClubAccount(){};
    public String getRole(){ return "Cycling Club"; }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumber(String phoneNumberString) {
        phoneNumberString = phoneNumberString.replace(String.valueOf("-"), "");
        phoneNumberString = phoneNumberString.replace(String.valueOf(" "), "");
        phoneNumberString = phoneNumberString.trim();

        int phoneNumber = Integer.parseInt(phoneNumberString);

        this.phoneNumber = phoneNumber;
    }

    public void setMainContact(String mainContact) {
        this.mainContact = mainContact;
    }

    public void setSocialMediaLink(URL socialMediaLink) {
        this.socialMediaLink = socialMediaLink;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getMainContact() {
        return this.mainContact;
    }

    public URL getSocialMediaLink() {
        return this.socialMediaLink;
    }
}
