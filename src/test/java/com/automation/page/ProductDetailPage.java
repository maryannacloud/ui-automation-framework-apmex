package com.automation.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductDetailPage extends BasePage {

    @FindBy(css = ".product-title")
    WebElement productTitle;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//a[text()='Begin Checkout']")
    WebElement beginCheckoutBtn;

    @FindBy(id = "attentive_creative")
    WebElement iframe;

    public void verifyPage() {
        Assert.assertTrue(productTitle.isDisplayed());
        Assert.assertTrue(addToCartBtn.isDisplayed());
    }

    public void clickAddToCartBtn() {

        Actions action = new Actions(driver);
        waitForElementToBeVisible(iframe);
        action.scrollToElement(iframe).build().perform();
        driver.switchTo().frame(iframe);
        action.keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).build().perform();
        driver.switchTo().parentFrame();

        waitForElementToBeClickable(addToCartBtn);
        addToCartBtn.click();
    }

    public void clickOnBeginCheckoutBtn() {
        waitForElementToBeVisible(beginCheckoutBtn);
        beginCheckoutBtn.click();
    }
}
