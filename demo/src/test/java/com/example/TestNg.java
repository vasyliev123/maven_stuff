package com.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class TestNg {
    WebDriver driver;
    
    @Parameters({"keyword"})
    @Test
    public void test(@Optional("default") String keyword) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\god\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver.get("http://www.google.com");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys(keyword);
        searchBar.submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchform")));
        Assert.assertTrue(driver.getTitle().contains(keyword)); 
    }
    
}
