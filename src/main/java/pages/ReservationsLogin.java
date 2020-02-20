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
    @FindBy(xpath = "//form//button[text()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[@id='alert']")
    WebElement alertBox;

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
        try {
            wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        } catch (TimeoutException ignored){}
    }

    public void logout() {
        logoutButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
    }

    public boolean isLogoutButtonPresent() {
        try {
            return logoutButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLoginFormPresent() {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(submitButton)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(alertBox)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
