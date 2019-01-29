package com.ttekobra.sparkresume.PojoClasses;

public class ExperienceDetails {

    public String JobTitle;
    public String CompanyName;
    public String Duration;
    public String Responsibility;
    public String Description;

    public ExperienceDetails(String jobTitle, String companyName, String duration, String responsibility, String description) {
        JobTitle = jobTitle;
        CompanyName = companyName;
        Duration = duration;
        Responsibility = responsibility;
        Description = description;
    }

    public ExperienceDetails() {

    }
}
