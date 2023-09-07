package seleniumExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sampleTest.propertyTests.propertiesFileTest;

public class TestNG_Demo {

    WebDriver driver = null;
    public static String browserName = null;

    @BeforeTest
    public void setUpTest() {

        propertiesFileTest.getProperties();

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/UMADHS3/Desktop/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:/Users/UMADHS3/Desktop/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

    }

    @Test
    public void googleSearch() {

        //goto google.com
        driver.get("https://google.com");

        //enter text in search textbox
        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

    }

    @AfterTest
    public void tearDownTest() {

        //close browser
        driver.close();
        //driver.quit();
        System.out.println("Test Completed Successfully");
        propertiesFileTest.setProperties();

    }
}
