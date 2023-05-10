package com.automation.tests;

import com.automation.page.CartPage;
import com.automation.page.HomePage;
import com.automation.page.ProductDetailPage;
import com.automation.page.SearchResultPage;
import com.automation.utils.DriverUtils;
import com.automation.utils.PropertyReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/*
BaseTest Class contains hooks in the form of the TestNG's @BeforeMethod and @AfterMethod annotations.
The reason I have used these particular annotations and not those for Suite, Test or Class - is for simplicity,
since I only have one method in my CartPageTest Class.
 */
public class BaseTest {

    HomePage homePage;
    CartPage cartPage;
    ProductDetailPage productDetailPage;
    SearchResultPage searchResultPage;

    @BeforeMethod
    public void setUp() {
        PropertyReader.initProperty();
        DriverUtils.createDriver();
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
