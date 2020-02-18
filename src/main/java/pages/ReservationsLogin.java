package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReservationsLogin extends BasePage {
    @FindBy(xpath = "//input[@id='username']//ancestor-or-self::form")
    WebElement loginForm;
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
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        wait.until(ExpectedConditions.invisibilityOf(logoutButton));
    }

    public boolean isLogoutButtonPresent() {
        try{
            return wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLoginFormPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(submitButton));
            return loginForm.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
