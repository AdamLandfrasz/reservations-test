package tests;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.*;
import pages.ReservationsHome;
import pages.ReservationsLogin;
import pages.ReservationsNewReservation;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NewReservation extends BaseTest {
    ReservationsLogin loginPage = new ReservationsLogin(driver);
    ReservationsHome homePage = new ReservationsHome(driver);
    ReservationsNewReservation newReservation = new ReservationsNewReservation(driver);

    @BeforeEach
    void adminLogin() {
        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, ADMIN_PW);
    }

    @Disabled
    @Test
    void addNewReservation() throws InterruptedException {
        newReservation.navigateToNewReservation();
        newReservation.fillForm();
    }

    @AfterEach
    void logoutAfterTest() {
        if (loginPage.isLogoutButtonPresent()) {
            loginPage.logout();
        }
    }
}
