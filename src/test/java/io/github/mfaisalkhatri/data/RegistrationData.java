package io.github.mfaisalkhatri.data;

import lombok.Data;

@Data
public class RegistrationData {

    private String firstName;
    private String lastName;
    private String dob;
    private String street;
    private String postalCode;
    private String city;
    private String state;
    private String country;
    private String phone;
    private String emailAddress;
    private String password;
}