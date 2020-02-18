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

    public void registerAdminUser(String username, String password){

        By adminRole = By.xpath("//*[@id=\"menu-role-native-required\"]//li[text()=\"ADMIN\"]");

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        roleDropdownElement.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(adminRole)).click();
        submitButton.click();
    }


    public void registerReceptionistUser(String username, String password){

        By receptionistRole = By.xpath("//*[@id=\"menu-role-native-required\"]//li[text()=\"RECEPTIONIST\"]");

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        roleDropdownElement.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(receptionistRole)).click();
        submitButton.click();
    }

}
