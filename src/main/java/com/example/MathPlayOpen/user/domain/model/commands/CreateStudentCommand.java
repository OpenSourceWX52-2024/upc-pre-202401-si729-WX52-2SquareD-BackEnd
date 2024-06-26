package com.example.MathPlayOpen.user.domain.model.commands;


public record CreateStudentCommand(String firstName, String lastName, String email, String password) {

}
