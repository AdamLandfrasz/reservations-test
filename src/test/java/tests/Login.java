package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ReservationsHome;
import pages.ReservationsLogin;

public class Login extends BaseTest {
    private final ReservationsLogin loginPage = new ReservationsLogin(driver);
    private final ReservationsHome homePage = new ReservationsHome(driver);

    @AfterEach
    void logoutAfterTest() {
        if (loginPage.isLogoutButtonPresentNoWait()) {
            loginPage.logout();
        }
    }

    @Test
    void adminLogin() {
        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, ADMIN_PW);
        Assertions.assertTrue(loginPage.isLogoutButtonPresent());
        Assertions.assertTrue(homePage.isNewUserLinkPresent());
    }

    @Test
    void receptionistLogin() {
        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(RECEPTIONIST_USERNAME, RECEPTIONIST_PW);
        Assertions.assertTrue(loginPage.isLogoutButtonPresent());
        Assertions.assertFalse(homePage.isNewUserLinkPresent());
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
        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, "invalid_pw");
        Assertions.assertTrue(loginPage.isAlertPresent());

        homePage.navigateToHome();
        Assertions.assertTrue(loginPage.isLoginFormPresent());
    }
}
