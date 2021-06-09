package test.java;

import main.java.pageEvents.CreateUserAccountPageEvents;
import main.java.pageEvents.HomePageEvents;
import main.java.pageEvents.LoginPageEvents;
import main.java.pageEvents.OrderItemsPageEvents;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class SampleTest  extends  BaseTest{

    @Test
    public void actionMethods() {
        HomePageEvents homePageEvents = new HomePageEvents();
        LoginPageEvents loginPageEvents = new LoginPageEvents();
        CreateUserAccountPageEvents userAccountPageEvents = new CreateUserAccountPageEvents();
        OrderItemsPageEvents orderItemsPageEvents = new OrderItemsPageEvents();
        homePageEvents.clickOnSignInButton();
        loginPageEvents.verifyLoginPageOpenedOrNot();
        loginPageEvents.clickCreateNewButton();
        userAccountPageEvents.CheckAccountDetailsText();
        userAccountPageEvents.EnterAccountDetails();
        userAccountPageEvents .CheckPersonalDetailsText();
        userAccountPageEvents.EnterPersonalDetails();
        userAccountPageEvents.CheckAddressText();
        userAccountPageEvents.EnterAddress();
        userAccountPageEvents.iAgree();
        userAccountPageEvents.clickRegisterButton();
        loginPageEvents.enterLoginDetails();
        loginPageEvents.loginSignIn();
        orderItemsPageEvents.orderItems();
        orderItemsPageEvents.clickAddToCart();
        orderItemsPageEvents.checkOutOrder();
        orderItemsPageEvents.orderPayment();
    }

}
