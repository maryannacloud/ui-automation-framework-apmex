package com.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
DriverUtils Class servers the purpose to instantiate the Object of the Driver
 */
public class DriverUtils {

    static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // global wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

    }
}
