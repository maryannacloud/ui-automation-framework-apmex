# Test Automation Framework for APMEX #

1. Definition: Java Project, based on a Maven Archetype
2. Tool stack: Java Programming Language, Selenium WebDriver library, TestNG Test Framework
3. Approach - Test-Driven Development
4. Design Pattern: Page Object Model via PageFactory library
5. Coverage: UI-level

Test Execution Instructions:
1. Within the Project structure, navigate to "tests" package and open CartPageTest Class
2. Locate the green "Run Test" button and click on it
3. Select "Run CartPageTest" option

User Story:
As a User I want to be able to search for a product and add it to my cart, so that I can purchase it later.

Test Steps:

Step 1:             Open the Apmex Web Application, by navigating to www.apmex.com
Expected Result:    Apmex Home Page opens up

Step 2:             Enter product name keywords in a Search Bar and click on Search button
Expected Result:    Search Results Page opens up showing results for the term searched

Step 3:             Hover over desired product from the list and click on it to open its Product Details Page
Expected Result:    Product Details Page opens up

Step 4:             Leave the Product Quantity set to "1" and click on Add to Cart button
Expected Result:    Cart preview pop-up window appears

Step 5:             Click Proceed to Checkout button on the pop-up window
Expected Result:    Cart Page opens up

Step 6:             Verify that the desired product is shown in the cart
Expected Result:    Desired product was successfully added to the cart
