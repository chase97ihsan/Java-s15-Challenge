package com.workintech.Library;

public class Address {

    private String city;
    private String district;
    private String street;
    private int number;

    public Address(String city, String district, String street, int number) {
        this.city = city;
        this.district = district;
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "City='" + city + '\'' +
                ", District='" + district + '\'' +
                ", Street='" + street + '\'' +
                ", Number=" + number +
                '}';
    }
}
