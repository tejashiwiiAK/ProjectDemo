package main.java.pageObjects;

public interface CreateUserAccountPageElements {

    String accountDetailsText = "//h3[contains(text(),'ACCOUNT DETAILS')]";
    String username = "input[name='usernameRegisterPage'][type=text]";
    String email = "input[name='emailRegisterPage'][type=text]";
    String pwd = "input[name='passwordRegisterPage'][type=password]";
    String cnfPassword = "input[name='confirm_passwordRegisterPage'][type=password]";

    String personalDetailsText = "//h3[contains(text(),'PERSONAL DETAILS')]";
    String firstname = "input[name='first_nameRegisterPage'][type=text]";
    String lastname = "input[name='last_nameRegisterPage'][type=text]";
    String phonenum = "input[name='phone_numberRegisterPage'][type=text]";

    String addressText = "//h3[contains(text(),'ADDRESS')]";
    String country ="//select[@name='countryListboxRegisterPage']";
    String city = "input[name='cityRegisterPage'][type=text]";
    String address = "input[name='addressRegisterPage'][type=text]";
    String state= "input[name='state_/_province_/_regionRegisterPage'][type=text]";
    String postalCode= "input[name='postal_codeRegisterPage'][type=text]";
    String agree = "input[name='i_agree'][type=checkbox]";
    String register = "button[id='register_btnundefined'][type=button]";
   // String userExists = "//label[contains(text(),'User name already exists')]";

    String accountExists = "//label[contains(text(),'ALREADY HAVE AN ACCOUNT?')]";




}
