package com.ttekobra.sparkresume.PojoClasses;

public class PersonalDetails {

    public String Profession;
    public String Nationality;
    public String DateOfBirth;
    public String Sex;
    public String MaritalStatus;

    public PersonalDetails(String profession, String nationality, String dateOfBirth, String sex, String maritalStatus) {
        Profession = profession;
        Nationality = nationality;
        DateOfBirth = dateOfBirth;
        Sex = sex;
        MaritalStatus = maritalStatus;
    }

    public PersonalDetails() {

    }
}
