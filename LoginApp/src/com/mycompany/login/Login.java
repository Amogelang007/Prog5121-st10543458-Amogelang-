/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

/**
 *
 * @author Student
 */

public class Login {
    String registeredUsername;
    String registeredPassword;
    String firstName;
    String lastName;

    public boolean checkUserName(String username) {
        if (username.length() > 5) {
            return false;
        }
        if (username.contains("_")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                hasCapital = true;
            }
            if (c >= '0' && c <= '9') {
                hasNumber = true;
            }
            if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%' || c == '*' || c == '_' || c == '+' || c == '-' || c == '?') {
                hasSpecial = true;
            }
        }
        return hasCapital && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber.length() != 12) {
            return false;
        }
        if (!cellNumber.startsWith("+27")) {
            return false;
        }
        for (int i = 3; i < 12; i++) {
            char c = cellNumber.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public String registerUser(String username, String password, String cellNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        }
        this.registeredUsername = username;
        this.registeredPassword = password;
        return "You have been successfully registered.";
    }

    public boolean loginUser(String username, String password) {
        if(username.equals(registeredUsername) && password.equals(registeredPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
    
