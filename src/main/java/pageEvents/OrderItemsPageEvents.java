package main.java.pageEvents;

import com.sun.tools.javac.comp.Enter;
import main.java.pageObjects.CreateUserAccountPageElements;
import main.java.pageObjects.HomePageElements;
import main.java.pageObjects.LoginPageElements;
import main.java.pageObjects.OrderItemsPageElements;
import main.utils.Constants;
import main.utils.ElementFetch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import test.java.BaseTest;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.Keys.ENTER;
import static test.java.BaseTest.driver;

public class OrderItemsPageEvents {
    public void orderItems() {
        WebElement ele = driver.findElement(By.id("tabletsImg"));
        Actions action = new Actions(driver);
        action.moveToElement(ele).build().perform();
        WebElement ele1 = driver.findElement(By.id("tabletsLink"));
        Actions action1 = new Actions(driver);
        action1.click(ele1).perform();
        System.out.println("clicked");
        this.sleep(10);
        WebElement l=driver.findElement(By.xpath("//button[contains(.,'BUY NOW')]"));
        // Javascript executor
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
        WebElement temp = driver.findElement(By.cssSelector("img[id='17']"));
        temp.click();
        System.out.println("clicked the temp value");
        this.sleep(5);

    }

    public void clickAddToCart(){
        WebElement addToCart = driver.findElement(By.xpath("//button[contains(.,'ADD TO CART')]"));
        addToCart.click();
        this.sleep(7);
        System.out.println("clicked add to cart value");
    }

    public void checkOutOrder(){
        WebElement shoppingCart = driver.findElement(By.id("shoppingCartLink"));
        shoppingCart.click();
        this.sleep(5) ;
        WebElement checkOutOrder = driver.findElement(By.id("checkOutPopUp"));
        checkOutOrder .click();
        WebElement checkOutOrderClick = driver.findElement(By.id("checkOutButton"));
        checkOutOrderClick .click();
    }

    public void orderPayment(){
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("orderpayment");
        elementFetch.getWebElement("XPATH", OrderItemsPageElements.orderPaymentText);
        elementFetch.getWebElement("XPATH",OrderItemsPageElements.nextButton).click();
        this.sleep(2);
        elementFetch.getWebElement("CSS", OrderItemsPageElements.safeUsername).clear();
        elementFetch.getWebElement("CSS", OrderItemsPageElements.safePassword).clear();
        elementFetch.getWebElement("CSS", OrderItemsPageElements.safeUsername).sendKeys(Constants.safeUsername);
        elementFetch.getWebElement("CSS", OrderItemsPageElements.safePassword).sendKeys(Constants.safePassword);
        WebElement l=driver.findElement(By.xpath("//button[contains(.,'PAY NOW')]"));
        // Javascript executor
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
        l.click();
//        elementFetch.getWebElement("XPATH",OrderItemsPageElements.payNowButton);
       System.out.println("payed");
        this.sleep(15);
        String OrderCompleted =  driver.findElement(By.xpath("//h2[contains(.,'Thank you for buying with Advantage')]")).getText();
        if(OrderCompleted.equals("Thank you for buying with Advantage")) {
            System.out.println("----------Sucess, order conpleted -------");
        }
        else
        {
            System.out.println("----------order is not successfull----------");
        }
    }
    public void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }
}