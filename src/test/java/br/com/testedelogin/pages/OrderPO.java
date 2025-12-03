package br.com.testedelogin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object representing the Order and Checkout page.
 * This class maps all elements required to perform product selection,
 * checkout, payment and order confirmation actions.
 */
public class OrderPO extends BasePO {

    @FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(1) > a")
    public WebElement linkDesktop;

    @FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li.dropdown.open > div > div > ul > li:nth-child(2) > a")
    public WebElement linkMac;

    @FindBy(css = "#content > div:nth-child(3) > div > div > div:nth-child(2) > div.button-group > button:nth-child(1)")
    public WebElement btnAddToCart;

    @FindBy(className = "alert-success")
    public WebElement divAlertMessageSuccess;

    @FindBy(id = "cart-total")
    public WebElement btnCheckout;

    @FindBy(css = "#cart > ul > li:nth-child(2) > div > p > a:nth-child(2)")
    public WebElement linkCheckout;

    @FindBy(css = "#content > h1")
    public WebElement divCheckout;

    @FindBy(id = "button-payment-address")
    public WebElement btnContinueBillingDetails;

    @FindBy(css = "#collapse-payment-address > div > form > div:nth-child(3) > label > input[type=radio]")
    public WebElement btnNewAddressBillingDetails;

    @FindBy(id = "input-payment-firstname")
    public WebElement inputFirstName;

    @FindBy(id = "input-payment-lastname")
    public WebElement inputLastName;

    @FindBy(id = "input-payment-company")
    public WebElement inputCompany;

    @FindBy(id = "input-payment-address-1")
    public WebElement inputAddress1;

    @FindBy(id = "input-payment-address-2")
    public WebElement inputAddress2;

    @FindBy(id = "input-payment-city")
    public WebElement inputCity;

    @FindBy(id = "input-payment-postcode")
    public WebElement inputPostCode;

    @FindBy(id = "input-payment-country")
    public WebElement inputCountry;

    @FindBy(id = "input-payment-zone")
    public WebElement inputRegionState;

    @FindBy(id = "button-shipping-address")
    public WebElement btnContinueDeliveryDetails;

    @FindBy(id = "button-shipping-method")
    public WebElement btnContinueDeliveryMethod;
    
    @FindBy(css = "#collapse-payment-method > div > div.buttons > div > input[type=checkbox]:nth-child(2)")
    public WebElement checkTermosConditions;

    @FindBy(id = "button-payment-method")
    public WebElement btnPaymentMethod;

    @FindBy(css = "#collapse-checkout-confirm > div > h2")
    public WebElement divBankTransferInstructions;

    @FindBy(id = "button-confirm")
    public WebElement btnConfirmOrder;

    @FindBy(css = "#content > h1")
    public WebElement divOrderSuccess;

    /**
     * Creates an instance of OrderPO and initializes all mapped elements.
     *
     * @param driver WebDriver instance used to control the browser.
     */
    public OrderPO(WebDriver driver) {
        super(driver);
    }
}