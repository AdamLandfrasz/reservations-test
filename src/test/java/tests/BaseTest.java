package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.MyProperties;

public abstract class BaseTest {
    static final String ADMIN_LOGIN = MyProperties.getAdminLogin();
    static final String ADMIN_PW = MyProperties.getAdminPw();

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
