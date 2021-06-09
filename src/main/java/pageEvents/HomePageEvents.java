package main.java.pageEvents;

import main.java.pageObjects.HomePageElements;
import main.utils.ElementFetch;
import test.java.BaseTest;

public class HomePageEvents {

    public void clickOnSignInButton(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("clicking on user button");
        elementFetch.getWebElement("ID", HomePageElements.userButton).click();
    }
}
