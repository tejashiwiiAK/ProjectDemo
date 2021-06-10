package main.java.pageEvents;

import main.java.pageObjects.CreateUserAccountPageElements;
import main.utils.Constants;
import main.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.java.BaseTest;

import java.util.concurrent.TimeUnit;

import static test.java.BaseTest.driver;

public class CreateUserAccountPageEvents {
    public void CheckAccountDetailsText(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("verify text Account Details");
        elementFetch.getWebElement("XPATH", CreateUserAccountPageElements.accountDetailsText);
    }

    public void EnterAccountDetails(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Enter Account Details");
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.username).sendKeys(Constants.username);
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.email).sendKeys(Constants.email);
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.pwd).sendKeys(Constants.password);
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.cnfPassword).sendKeys(Constants.confirmPassword);
    }

    public void CheckPersonalDetailsText(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("verify text Personal Details");
        elementFetch.getWebElement("XPATH", CreateUserAccountPageElements.personalDetailsText);
    }

    public void EnterPersonalDetails() {
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Enter Personal Details");
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.firstname).sendKeys(Constants.firstName);
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.lastname).sendKeys(Constants.lastname);
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.phonenum).sendKeys(Constants.phoneNumber);
    }

    public void CheckAddressText(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("verify text Address");
        elementFetch.getWebElement("XPATH", CreateUserAccountPageElements.addressText);
    }


    public void EnterAddress() {
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Enter Address Details");
        elementFetch.getWebElement("XPATH", CreateUserAccountPageElements.country).getCssValue(Constants.country);
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.city).sendKeys(Constants.city);
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.address).sendKeys(Constants.address);
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.state).sendKeys(Constants.state);
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.postalCode).sendKeys(Constants.postalCode);
    }

    public void iAgree(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("click Agree button");
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.agree).click();
    }

    public void clickRegisterButton(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("click Register button");
        elementFetch.getWebElement("CSS", CreateUserAccountPageElements.register).click();
        try
        {
            WebElement userAlreadyExistsText = driver.findElement(By.xpath("//label[contains(text(),'User name already exists')]"));
            String text = userAlreadyExistsText.getText();
            if(text.equals("User name already exists"))
            { System.out.println("----------user already exists-------\n-----------------------");
               Assert.assertEquals(text,"User name already exists");

                driver.findElement(By.xpath("//label[contains(@class, 'ALREADY_HAVE_AN_ACCOUNT roboto-medium')]")).click();
               Thread.sleep(10000);

            }else
            {
                System.out.println("----------create new account ----------\n-----------------------");
                clickRegisterButton();
            }
        }
        catch(Throwable e)
        {
            System.out.println("Inbox not found: "+e.getMessage());
        }
    }

}
