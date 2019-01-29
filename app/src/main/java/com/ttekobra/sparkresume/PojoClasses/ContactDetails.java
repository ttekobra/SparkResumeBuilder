package com.ttekobra.sparkresume.PojoClasses;

public class ContactDetails {

    public String FirstName;
    public String LastName;
    public String MobileNumber;
    public String Email;
    public String ResidentialAddress;

    public ContactDetails(String firstName, String lastName, String mobileNumber, String email, String residentialAddress) {
        FirstName = firstName;
        LastName = lastName;
        MobileNumber = mobileNumber;
        Email = email;
        ResidentialAddress = residentialAddress;
    }

    public ContactDetails() {

    }
}
