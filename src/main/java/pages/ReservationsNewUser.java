package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReservationsNewUser extends BasePage {
    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement usernameField;
    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"role\"]")
    WebElement roleDropdownElement;
    @FindBy(xpath = "//*[@id=\"root\"]//input[@type=\"submit\"]")
    WebElement submitButton;


    public ReservationsNewUser(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToNewUser() {
        navigateToUrl("adduser");
    }

    public void registerUser(String username, String password, String role){

        By selectedRole = By.xpath("//li[@data-value='" + role +"']");

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(roleDropdownElement)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(selectedRole)).click();
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    public void registerUserWithoutRole(String username, String password){

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    public void goToAddUserURL(){
        navigateToUrl("adduser");
    }

}
