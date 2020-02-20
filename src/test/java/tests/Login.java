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
        Assertions.assertTrue(loginPage.isLogoutButtonPresent());
    }

    @Test
    void logout() {
        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, ADMIN_PW);
        loginPage.logout();

        homePage.navigateToHome();
        Assertions.assertTrue(loginPage.isLoginFormPresent());
    }

    @Test
    void invalidLogin() {
        ReservationsHome homePage = new ReservationsHome(driver);

        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, "invalid_pw");
        Assertions.assertTrue(loginPage.isAlertPresent());

        homePage.navigateToHome();
        Assertions.assertTrue(loginPage.isLoginFormPresent());
    }
}
