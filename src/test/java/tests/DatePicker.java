package tests;

import org.junit.jupiter.api.*;
import pages.ReservationsHome;
import pages.ReservationsLogin;

public class DatePicker extends BaseTest{

    @Test
    void sout() {
        ReservationsLogin loginPage = new ReservationsLogin(driver);

        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, ADMIN_PW);

        System.out.println("valami");

        ReservationsHome homePage = new ReservationsHome(driver);
        loginPage.logout();
        homePage.navigateToHome();
    }


}

