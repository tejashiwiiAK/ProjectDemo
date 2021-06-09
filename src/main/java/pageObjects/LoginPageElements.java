package main.java.pageObjects;

public interface LoginPageElements {
    //String createNewButton ="//a[contains(text(),'create-new-account')]";
    String createNewButton = "//a[contains(text(),'CREATE NEW ACCOUNT')]";
//    String emailAddress = "ap_email";

    String clickSignIn = "button[id='sign_in_btnundefined'][type=button]";
//    String clickSignIn = "sign_in_btnundefined";
    String usernameLog = "input[name='username'][type=text]";
    String passwordLog= "input[name='password'][type=password]";

    String userloggedin ="menuUserLink";


}