package com.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.lang.reflect.Method;
import java.net.URL;

import java.time.Duration;

/*
DriverUtils Class servers the purpose to instantiate the Object of the Driver
 */

public class DriverUtils {

    static WebDriver driver;

    public static void createDriver(Method test){

        // determining which browser to run the test on, as per requirement, to keep things simple - setting Chrome to default:
        if(PropertyReader.getProperty("application.host").equalsIgnoreCase("local")) {

            if (driver == null) {
                switch (PropertyReader.getProperty("application.browser")) {

                    // since the test will execute on the local machine - having the browsers installed is a must, otherwise - this won't work
                    case "edge" -> {
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                    }
                    case "safari" -> {
                        WebDriverManager.safaridriver().setup();
                        driver = new SafariDriver();
                    }
                    case "firefox" -> {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                    }
                    default -> {

                        // WebDriverManager essentially removes the need to manually manage any drivers
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                    }
                }
            }

        // else if the value of the application.host is SauceLabs, we are setting up a remote driver to run test on SauceLabs:
        } else if (PropertyReader.getProperty("application.host").equalsIgnoreCase("saucelabs")){

            MutableCapabilities sauceOptions = new MutableCapabilities();
            sauceOptions.setCapability("username", PropertyReader.getProperty("sauce.username"));
            sauceOptions.setCapability("accessKey", PropertyReader.getProperty("sauce.accessKey"));

            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("browserName", PropertyReader.getProperty("sauce.browserName"));
            capabilities.setCapability("browserVersion", PropertyReader.getProperty("sauce.browserVersion"));
            capabilities.setCapability("platformName", PropertyReader.getProperty("sauce.platformName"));
            capabilities.setCapability("sauce:options", sauceOptions);

            try {
                // here we are initializing the WebDriver to a Remote driver and passing the URL to the SauceLabs hub
                driver = new RemoteWebDriver(new URL(PropertyReader.getProperty("sauce.urlWest")), capabilities); // URL Constructor throws the MalformedURLException
                ((JavascriptExecutor)driver).executeScript("sauce:job-name=" + test.getName());
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        driver.manage().window().maximize();

        // global wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get(PropertyReader.getProperty("application.url"));
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
