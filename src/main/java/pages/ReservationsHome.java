package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReservationsHome extends BasePage {
    @FindBy(xpath = "//button[text()='Logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//a[@href='/home']")
    WebElement homeLink;
    @FindBy(xpath = "//a[@href='/rooms']")
    WebElement roomsLink;
    @FindBy(xpath = "//a[@href='/newguest']")
    WebElement newGuestLink;
    @FindBy(xpath = "//a[@href='/adduser']")
    WebElement newUserLink;

    public ReservationsHome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public boolean isLogoutButtonPresent() {
        try{
            return wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
