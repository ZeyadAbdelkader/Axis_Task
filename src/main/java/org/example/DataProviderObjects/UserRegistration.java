package org.example.DataProviderObjects;

import Utilities.CustomAnnotations;

public class UserRegistration {
    @CustomAnnotations.ExcelColumn (2)
    String Firstname;
    @CustomAnnotations.ExcelColumn (3)
    String Lastname;
    @CustomAnnotations.ExcelColumn(4)
    String Email;

    @CustomAnnotations.ExcelColumn(5)
    String Password;

    @CustomAnnotations.ExcelColumn(6)
    String ConfirmPassword;
    @CustomAnnotations.ExcelColumn(7)
    String Messages;


    public String getFirstName() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }
    public String getMessages() {
        return Messages;
    }
}
