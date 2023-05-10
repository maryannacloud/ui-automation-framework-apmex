package com.automation.tests;

import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    // test method that pretty much replicates the steps I described in the readme.md file
    @Test
    public void verifyUserCanAddItemIntoCart() {
        homePage.openWebsite();
        homePage.searchWithKeyword("search.term");
        searchResultPage.verifySearchResults();
        searchResultPage.verifyItemPresentInSearchResults("product.name");
        searchResultPage.clickOnItem("product.name");
        productDetailPage.verifyPage();
        productDetailPage.clickAddToCartBtn();
        productDetailPage.clickOnBeginCheckoutBtn();
        cartPage.verifyCartPage();
        cartPage.verifyItemPresentInCartPage();
    }

}
