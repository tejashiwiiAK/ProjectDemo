package main.java.pageObjects;

public interface LoginPageElements {
    String createNewButton = "//a[contains(text(),'CREATE NEW ACCOUNT')]";
    String clickSignIn = "button[id='sign_in_btnundefined'][type=button]";
    String usernameLog = "input[name='username'][type=text]";
    String passwordLog= "input[name='password'][type=password]";
    String userloggedin ="menuUserLink";
}