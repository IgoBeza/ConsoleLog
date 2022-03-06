package consoleLog;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class consoleLog {

    ChromeDriver driver;

    @BeforeClass
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void  viewBrowserCosoleLogo() {

        // Get the DevTools & Creat A Session

        DevTools DevTools = driver.getDevTools();
        DevTools.createSession();

        //Enable the Console Logs

        DevTools.send(Log.enable());

        // Add A Listener For The Console Log
        DevTools.addListener(Log.entryAdded(),logEntry -> {
            System.out.println("----------");
            System.out.println("Level:" + logEntry.getLevel());
            System.out.println("text:" + logEntry.getText());
            System.out.println("Broken URL:" + logEntry.getUrl());

        });


        // Load The AUT
        driver.get("https://the-internet.herokuapp.com/broken_images");


    }



}
