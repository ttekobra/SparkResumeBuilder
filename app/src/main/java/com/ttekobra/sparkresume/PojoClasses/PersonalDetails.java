package com.ttekobra.sparkresume.PojoClasses;

public class PersonalDetails {

    public String Profession;
    public String Nationality;
    public String DateOfBirth;
    public String Sex;
    public String Hobbies;
    public String KnownLanguages;

    public PersonalDetails(String profession, String nationality, String dateOfBirth, String sex, String hobbies, String knownLanguages) {
        Profession = profession;
        Nationality = nationality;
        DateOfBirth = dateOfBirth;
        Sex = sex;
        Hobbies = hobbies;
        KnownLanguages = knownLanguages;
    }

    public PersonalDetails() {

    }
}
