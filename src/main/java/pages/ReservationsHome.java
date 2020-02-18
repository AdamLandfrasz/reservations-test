package pages;

import org.openqa.selenium.NoSuchElementException;
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
    @FindBy(xpath = "//a[@href='/newguest']")
    WebElement newGuestLink;
    @FindBy(xpath = "//a[@href='/adduser']")
    WebElement newUserLink;

    public ReservationsHome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToHome() {
        navigateToUrl("home");
    }

    public void navigateToNewUserPage(){

        newUserLink.click();
    }
}
