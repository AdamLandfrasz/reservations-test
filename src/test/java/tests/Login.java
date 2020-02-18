package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ReservationsHome;
import pages.ReservationsLogin;

public class Login extends BaseTest {
    @Test
    void successfulLogin() {
        ReservationsLogin loginPage = new ReservationsLogin(driver);

        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, ADMIN_PW);
        Assertions.assertTrue(loginPage.isLogoutButtonPresent());
    }

    @Test
    void logout() {
        ReservationsLogin loginPage = new ReservationsLogin(driver);
        ReservationsHome homePage = new ReservationsHome(driver);

        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, ADMIN_PW);
        loginPage.logout();
        homePage.navigateToHome();
        Assertions.assertTrue(loginPage.isLoginFormPresent());
    }
}
