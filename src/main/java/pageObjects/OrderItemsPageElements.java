package main.java.pageObjects;

public interface OrderItemsPageElements {

    String orderPaymentText = "//h3[contains(text(),'ORDER PAYMENT')]";
    String shippingDetailsText = "//label[contains(text(),'SHIPPING DETAILS')]";
    String nextButton = "//button[contains(.,'NEXT')]";
    String paymentMethodText = "//label[contains(text(),'PAYMENT METHOD')]";
    String safeUsername = "input[name='safepay_username'][type=text]";
    String safePassword = "input[name='safepay_password'][type=password]";
    String payNowButton = "//button[contains(.,'PAY NOW')]";










}