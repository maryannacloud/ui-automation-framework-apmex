package com.automation.page;

import com.automation.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage {

    // in case if the user wanted to change what they wanted to search for in the config file, that is why we're using the '%s'
    final String XPATH_ITEM_NAME = "//div[@class='mod-product-title']/h4[text()='%s']";

    @FindBy(css = ".mod-product-title h4")
    List<WebElement> searchResultList;

    @FindBy(css = ".current-category-name")
    WebElement searchTerm;

    @FindBy(xpath = "//a[@class='cc-btn cc-dismiss']")
    WebElement cookieCloseBtn;

    @FindBy(id = "attentive_creative")
    WebElement iFrame;

    @FindBy(id="dismissbutton2header1")
    WebElement iFrameDismissBtn;

    public void verifySearchResults() {
        Assert.assertTrue(searchResultList.size() > 0);
        Assert.assertTrue(searchTerm.isDisplayed());
        String expTermName = PropertyReader.getProperty("search.term");
        // since the text on the search term label includes quotes and the text in config file doesnt
        // but that is what we are comparing this to - we have to remove the quotes
        String actTermName = searchTerm.getText().replace("\"", "");
        Assert.assertEquals(actTermName, expTermName);
    }

    public void verifyItemPresentInSearchResults(String itemName) {
        List<String> itemNames = new ArrayList<>();

        for (WebElement element : searchResultList) {
            itemNames.add(element.getText());
        }

        Assert.assertTrue(itemNames.contains(PropertyReader.getProperty(itemName)));
    }

    public void clickOnItem(String itemName) {

        waitForElementToBeVisible(iFrame);

        if(isPresent(iFrame)){
            driver.switchTo().frame(iFrame);
            iFrameDismissBtn.click();
            driver.switchTo().defaultContent();
        }


        if (isPresent(cookieCloseBtn)) {
            cookieCloseBtn.click();
        }
        WebElement itemNameElement = driver.findElement(By.xpath(String.format(XPATH_ITEM_NAME, PropertyReader.getProperty(itemName))));
        clickElementByJS(itemNameElement);
    }
}
