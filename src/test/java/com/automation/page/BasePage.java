package com.automation.page;

import com.automation.utils.DriverUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
The BasePage is not an actual page of the Web Application. BasePage is the Parent (Super) Class,
which contains fields (variables) and functions (methods) that might be needed for it's Child (Sub) Classes.
In our case here, the Child Classes are the actual Pages of the AUT, through which the User navigates,
while performing the Steps of the Test Case.

 */
public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    BasePage() {
        driver = DriverUtils.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickElementByJS(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click", element);
        }
    }

    public boolean isPresent(WebElement element){
        try{
            element.isDisplayed();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
