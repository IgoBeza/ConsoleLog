package OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocator {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void testRelativeLocator(){

        WebElement loginPanel = driver.findElement(By.id("logInPanelHeading"));
        WebElement credential = driver.findElement(org.openqa.selenium.support.locators.RelativeLocator.with(

        By.tagName("span")
        ).above(loginPanel));
        System.out.println(credential.getText());
    }


}
