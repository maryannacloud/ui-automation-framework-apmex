package com.automation.tests;

import com.automation.page.CartPage;
import com.automation.page.HomePage;
import com.automation.page.ProductDetailPage;
import com.automation.page.SearchResultPage;
import com.automation.utils.DriverUtils;
import com.automation.utils.PropertyReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/*
BaseTest Class contains hooks in the form of the TestNG's @BeforeMethod and @AfterMethod annotations.
The reason I have used these particular annotations and not those for Suite, Test or Class - is for simplicity,
since I only have one method in my CartPageTest Class.
 */
public class BaseTest {

    // Objects of the child pages of the BasePage:
    HomePage homePage;
    CartPage cartPage;
    ProductDetailPage productDetailPage;
    SearchResultPage searchResultPage;

    @BeforeMethod
    public void setUp(Method test) {
        PropertyReader.initProperty();

        // before we can get the Driver, the driver needs to be created (instantiated)
        DriverUtils.createDriver(test);

        // when the Objects of these pages get instantiated, the Constructor of their Parent Page (BasePage) will get called (Constructor chaining concept)
        // when the BasePage Constructor get called it will get the driver, initialize it's web elements with the help of the PageFactory
        homePage = new HomePage();
        cartPage = new CartPage();
        productDetailPage = new ProductDetailPage();
        searchResultPage = new SearchResultPage();
    }

    @AfterMethod
    public void cleanUp() {
        DriverUtils.getDriver().quit();
    }

}
