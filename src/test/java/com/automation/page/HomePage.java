package com.automation.page;

import com.automation.utils.PropertyReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "q")
    WebElement searchBox;

    @FindBy(id = "q-search-submit")
    WebElement searchBtn;


    public void openWebsite() {
        driver.get(PropertyReader.getProperty("application.url"));
    }

    public void searchWithKeyword(String searchTerm) {
        waitForElementToBeVisible(searchBox);
        searchBox.sendKeys(PropertyReader.getProperty(searchTerm));
        searchBtn.click();
    }
}
