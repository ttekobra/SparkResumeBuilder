package com.ttekobra.sparkresume.PojoClasses;

public class ExtraDetails {

    public String KnownLanguages;
    public String InterestTitle;
    public String InterestDescription;
    public String ExtraActivityTitle;
    public String ExtraActivityDesciption;

    public ExtraDetails(String knownLanguages, String interestTitle, String interestDescription, String extraActivityTitle, String extraActivityDesciption) {
        KnownLanguages = knownLanguages;
        InterestTitle = interestTitle;
        InterestDescription = interestDescription;
        ExtraActivityTitle = extraActivityTitle;
        ExtraActivityDesciption = extraActivityDesciption;
    }

    public ExtraDetails() {

    }
}
