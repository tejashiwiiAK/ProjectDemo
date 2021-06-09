package main.java.pageEvents;

import main.java.pageObjects.LoginPageElements;
import main.utils.Constants;
import main.utils.ElementFetch;
import org.testng.Assert;
import test.java.BaseTest;

public class LoginPageEvents {

    public void verifyLoginPageOpenedOrNot() {
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Verifying that the login page opened or not");
        Assert.assertTrue(elementFetch.getListWebElements("XPATH", LoginPageElements.createNewButton).size() > 0, "Login page did not open");
    }

    public void clickCreateNewButton(){
        ElementFetch elementFetch =  new ElementFetch();
        BaseTest.logger.info("create the new account");
        elementFetch.getWebElement("XPATH",LoginPageElements.createNewButton).click();
    }

    public void enterLoginDetails() {
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Enter Login Details");
        elementFetch.getWebElement("CSS", LoginPageElements.usernameLog).sendKeys(Constants.usernameLog);
        elementFetch.getWebElement("CSS", LoginPageElements.passwordLog).sendKeys(Constants.passwordLog);
    }

    public void loginSignIn(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Click sign in button");
        try
        {
            elementFetch.getWebElement("CSS", LoginPageElements.clickSignIn).click();
           // elementFetch.getWebElement("ID", LoginPageElements.clickSignIn).click();
            Thread.sleep(5000);
        }
        catch(Throwable e)
        {
            System.out.println("Signin not found: "+ e.getMessage());
        }
        System.out.println("signed in");
        String LoggedIn =  elementFetch.getWebElement("ID", LoginPageElements.userloggedin).getText();
        if(LoggedIn.equals(Constants.username)) {
            System.out.println("----------Sucess -------");
        }
        else
        {
            System.out.println("----------Failure----------");
        }
    }
}
