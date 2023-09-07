package seleniumExample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ifsAssignment {


    WebDriver driver = null;
    public static String browserName = null;

    @BeforeTest
    public void setUpTest() {

        System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromeDriver\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void verifyLoginPage() {
        WebElement loginLink = driver.findElement(By.linkText("Sign in"));
        loginLink.click();
        WebElement emailInput = driver.findElement(By.id("userid"));
        emailInput.sendKeys("salikamadhushanka33@gmail.com");

        WebElement btnSigningContinue = driver.findElement(By.id("signin-continue-btn"));
        Wait<WebDriver> wait = new WebDriverWait(driver, 10000);
        wait.until(d -> btnSigningContinue.isDisplayed());
        btnSigningContinue.click();

        WebElement passwordInput = driver.findElement(By.id("pass"));
        wait.until(d -> passwordInput.isDisplayed());
        passwordInput.sendKeys("Salika123@");
        passwordInput.submit();


    }

    @Test(priority = 2)
    public void itemSearchAndVerify() {
        driver.get("https://www.ebay.com/");
        WebElement searchBar = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        searchBar.sendKeys("Smartwatch");

        WebElement btnSearch = driver.findElement(By.id("gh-btn"));
        btnSearch.click();

        WebElement itemName = driver.findElement(By.xpath("(//div[@class='s-item__wrapper clearfix'])[2]//div[@class='s-item__title']/span"));
        String itemTitle=itemName.getText();

        WebElement selectFirstItem = driver.findElement(By.xpath("(//div[@class='s-item__wrapper clearfix'])[2]//div[@class='s-item__title']"));
        selectFirstItem.click();

        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        WebElement enterNumOfItem  = driver.findElement(By.id("qtyTextBox"));
        enterNumOfItem.clear();
        enterNumOfItem.sendKeys("2");

        WebElement btnAddToCart  = driver.findElement(By.xpath("//span[text()='Add to cart']"));
        btnAddToCart.click();

        WebElement addedItemName = driver.findElement(By.xpath("//div[@class='listsummary-content-itemdetails']//span[@CLASS='BOLD']"));
        String addedItemTitleName=addedItemName.getText();
        Assert.assertEquals(itemTitle,addedItemTitleName);

        driver.close();
        driver.switchTo().window(winHandleBefore);

    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
        System.out.println("Test Completed Successfully");

    }
}
