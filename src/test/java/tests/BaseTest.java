package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.MyProperties;

public abstract class BaseTest {
    static final String ADMIN_USERNAME = MyProperties.getAdminUsername();
    static final String ADMIN_PW = MyProperties.getAdminPw();
    static final String RECEPTIONIST_USERNAME = MyProperties.getUserUsername();
    static final String RECEPTIONIST_PW = MyProperties.getUserPw();

    static WebDriver driver;

    @BeforeAll
    static void setUp() {
        switch (MyProperties.getDriver()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
