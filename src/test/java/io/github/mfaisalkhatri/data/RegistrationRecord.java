package io.github.mfaisalkhatri.data;

public record RegistrationRecord(String firstName, String lastName, String dob, String street, String postalCode,
                                 String city, String state, String country, String phone, String emailAddress,
                                 String password) {

}