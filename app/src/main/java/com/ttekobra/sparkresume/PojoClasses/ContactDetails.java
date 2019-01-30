package com.ttekobra.sparkresume.PojoClasses;

public class ContactDetails {

    public String FullName;
    public String MobileNumber;
    public String Email;
    public String ResidentialAddress;

    public ContactDetails(String fullName, String mobileNumber, String email, String residentialAddress) {
        FullName = fullName;
        MobileNumber = mobileNumber;
        Email = email;
        ResidentialAddress = residentialAddress;
    }

    public ContactDetails() {

    }
}
