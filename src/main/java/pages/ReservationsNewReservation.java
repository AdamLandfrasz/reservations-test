package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationsNewReservation extends BasePage {
    // Constructor
    public ReservationsNewReservation(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    // WebElements
    @FindBy(xpath = "//a[@href='/newreservation']")
    WebElement newReservationLink;

    @FindBy(xpath = "//h6[text()='New Reservation']")
    WebElement newReservationForm;

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='country']")
    WebElement country;

    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement zipCode;

    @FindBy(xpath = "//input[@id='city']")
    WebElement city;

    @FindBy(xpath = "//input[@id='street']")
    WebElement street;

    @FindBy(xpath = "/html/body/div/div/div/div/form/span[1]/div/input")
    WebElement selectCheckinDate;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[1]/div/input")
    WebElement inputCheckinDate;

    @FindBy(xpath = "/html/body/div/div/div/div/form/span[2]/div/input")
    WebElement selectCheckoutDate;

    //@FindBy(xpath = "//input[@class='ant-calendar-input ']")
    @FindBy(xpath = "/html/body/div[3]/div/div/div/div/div[1]/div/input")
    WebElement inputCheckoutDate;

    @FindBy(xpath = "//input[@id='price']")
    WebElement price;

    @FindBy(xpath = "//input[@id='payment-method-label']")
    WebElement paymentMethod;


    public void navigateToNewReservation() {
        navigateToUrl("newreservation");
    }

    public boolean newReservationFormIsPresent() {
        return newReservationForm.isDisplayed();
    }

    public void fillForm() throws InterruptedException {
        LocalDateTime currentTime = LocalDateTime.now();
        String currentMonth = String.valueOf(LocalDate.now().getMonthValue());
        String currentYear = String.valueOf(LocalDate.now().getYear());
        String currentMonthInput = currentMonth;
        if (LocalDate.now().getMonthValue() < 10) {
            currentMonthInput = "0"+currentMonth;
        }
        firstName.sendKeys(currentTime.toString());
        lastName.sendKeys("Smith");
        email.sendKeys("test@gmail.com");
        country.sendKeys("Hungary");
        zipCode.sendKeys("1111");
        city.sendKeys("Budapest");
        street.sendKeys("albáni pékség 11.");
        selectCheckinDate.click();
        inputCheckinDate.sendKeys(currentYear+"-"+currentMonthInput+"-01");
        selectCheckoutDate.click();
        inputCheckoutDate.sendKeys(currentYear+"-"+currentMonthInput+"-02");
        price.click();
        price.sendKeys("100");
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethod)).click();
        By selectedMethod = By.xpath("//li[@data-value='CASH']");
        wait.until(ExpectedConditions.presenceOfElementLocated(selectedMethod)).click();
        paymentMethod.click();
        Thread.sleep(3000);

    }
}
