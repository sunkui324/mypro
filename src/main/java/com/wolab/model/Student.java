package com.wolab.model;

public class Student {

    private String firstName;

    private String lastName;

    private Double grade;

    public Double feeDiscount=0.0;

    public Double baseFee =20000.0;

    public Student(String firstName,String lastName,Double grade){
        this.firstName=firstName;
        this.lastName=lastName;
        this.grade=grade;
    }

    public void printFee(){
        Double newFee=baseFee - ((baseFee*feeDiscount)/1000);
        System.out.println("The fee after discount :"+ newFee);
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

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Double getFeeDiscount() {
        return feeDiscount;
    }

    public void setFeeDiscount(Double feeDiscount) {
        this.feeDiscount = feeDiscount;
    }

    public Double getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(Double baseFee) {
        this.baseFee = baseFee;
    }
}
