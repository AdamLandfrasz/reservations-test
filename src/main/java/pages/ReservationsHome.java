package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReservationsHome extends BasePage {
    @FindBy(xpath = "//a[@href='/home']")
    WebElement homeLink;
    @FindBy(xpath = "//a[@href='/rooms']")
    WebElement roomsLink;
    @FindBy(xpath = "//a[@href='/newreservation']")
    WebElement newReservationLink;
    @FindBy(xpath = "//a[@href='/adduser']")
    WebElement newUserLink;

    @FindBy(xpath = "//button[@class='react-datetime-picker__clear-button react-datetime-picker__button']")
    WebElement datePicker;

    @FindBy(xpath = "//button[@text()='Submit']")
    WebElement submitButton;

    public ReservationsHome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToHome() {
        navigateToUrl("home");
    }

    public void navigateToNewUser() {
        navigateToUrl("adduser");
    }

    public void clearDate() {

    }

    public boolean isNewUserLinkPresent() {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(newUserLink)).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
