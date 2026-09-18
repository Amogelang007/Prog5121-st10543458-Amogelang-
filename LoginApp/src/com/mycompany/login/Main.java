/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        System.out.print("Enter First Name: ");
        login.firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        login.lastName = scanner.nextLine();
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Cell Number ");
        String cellNumber = scanner.nextLine();
        String registration = login.registerUser(username, password, cellNumber);
        System.out.println(registration);
        if (registration.equals("You have been successfully registered.")) {
            System.out.print("Enter username to login: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Enter password to login: ");
            String loginPassword = scanner.nextLine();
            boolean loggedIn = login.loginUser(loginUsername, loginPassword);
            System.out.println(login.returnLoginStatus(loggedIn));
        }
        scanner.close();
    }
}