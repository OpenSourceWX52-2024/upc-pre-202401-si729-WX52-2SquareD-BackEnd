package com.example.MathPlayOpen.user.interfaces.rest.resources;


public record CreateStudentResource(String firstName, String lastName, String email, String street, String number, String city, String postalCode, String country) {
}