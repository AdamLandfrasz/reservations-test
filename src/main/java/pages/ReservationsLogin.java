package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReservationsLogin extends BasePage {
    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//button[text()='Logout']")
    WebElement logoutButton;

    public ReservationsLogin(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToLogin() {
        navigateToUrl("login");
    }

    public void loginWithCredentials(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void logout() {
        By loginPageForm = By.xpath("//form[//button[text()='Submit']]");

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(loginPageForm));
    }

    public boolean isLogoutButtonPresent() {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean isLoginFormPresent() {
        By loginPageForm = By.xpath("//input[@id='username']//ancestor-or-self::form");

        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(loginPageForm)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        By loginPageForm = By.xpath("//div[@id='alert']");

        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(loginPageForm)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
