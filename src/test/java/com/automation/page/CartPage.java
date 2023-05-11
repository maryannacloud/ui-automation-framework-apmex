package com.automation.page;

import com.automation.utils.PropertyReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage extends BasePage {

    @FindBy(css = ".co-page-header h1")
    WebElement pageTitle;

    @FindBy(className = "product-title-link")
    WebElement productTitle;

    public void verifyCartPage() {
        Assert.assertTrue(pageTitle.isDisplayed());
    }

    public void verifyItemPresentInCartPage() {
        Assert.assertTrue(productTitle.isDisplayed());
        String expProductName = PropertyReader.getProperty("product.name");
        String actProductName = productTitle.getText();
        Assert.assertEquals(actProductName, expProductName);
    }
}
