package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ReservationsHome;
import pages.ReservationsLogin;
import tests.Login;

public class DatePicker extends BaseTest{
    private final ReservationsHome homePage = new ReservationsHome(driver);
    private final ReservationsLogin loginPage = new ReservationsLogin(driver);

    @BeforeEach
    void login() {
        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, ADMIN_PW);
    }

    @AfterAll
    void logout() {
        loginPage.logout();
        homePage.navigateToHome();
    }

}
