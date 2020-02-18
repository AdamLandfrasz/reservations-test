package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.MyProperties;

public abstract class BaseTest {
    static final String ADMIN_USERNAME = MyProperties.getAdminUsername();
    static final String ADMIN_PW = MyProperties.getAdminPw();
    static final String USER_USERNAME = MyProperties.getUserUsername();
    static final String USER_PW = MyProperties.getUserPw();

    WebDriver driver;

    @BeforeEach
    void setUp() {
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

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
