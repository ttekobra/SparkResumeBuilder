package com.ttekobra.sparkresume.PojoClasses;

public class AcademicsDetails {


    public String StartYear;
    public String EndYear;
    public String Degree;
    public String University;
    public String Percentage;

    public AcademicsDetails(String startYear, String endYear, String degree, String university, String percentage) {
        StartYear = startYear;
        EndYear = endYear;
        Degree = degree;
        University = university;
        Percentage = percentage;
    }

    public AcademicsDetails() {

    }
}
