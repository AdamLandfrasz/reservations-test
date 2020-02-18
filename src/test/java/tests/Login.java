package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ReservationsHome;
import pages.ReservationsLogin;

public class Login extends BaseTest {
    private final ReservationsLogin loginPage = new ReservationsLogin(driver);
    private final ReservationsHome homePage = new ReservationsHome(driver);

    @Test
    void successfulLogin() {
        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, ADMIN_PW);
        Assertions.assertTrue(homePage.isLogoutButtonPresent());
    }
}
