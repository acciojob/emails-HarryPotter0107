package com.driver;

import java.util.regex.Pattern;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(oldPassword.equals(this.password)){
            if(isValidPassword(newPassword)){
                this.password = newPassword;
                //System.out.println("Password changed successfully.");
            }
//            else{
//                System.out.println("The new Password is not valid.");
//            }
//        }else{
//            System.out.println("The provided password doesn't match with old password");
        }
    }

    private Boolean isValidPassword(String newPassword) {
        Boolean capitalLetter = false;
        Boolean smallLetter = false;
        Boolean digit = false;
        Boolean specialChar = false;

        if(newPassword.length() < 8){
            return false;
        }
        for (int i = 0; i < newPassword.length(); i++) {
            char ch = newPassword.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                capitalLetter = true;
            }else if(ch >= 'a' && ch <= 'z'){
                smallLetter = true;
            }else if(ch >= '0' && ch <= '9'){
                digit = true;
            }else{
                specialChar = true;
            }
        }
        if(specialChar && smallLetter && capitalLetter && digit){
            return true;
        }
        return false;
    }
}