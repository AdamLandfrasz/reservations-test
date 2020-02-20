package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;

public class NewUser extends BaseTest {

    @Test
    void registerValidUser(){
        final ReservationsLogin loginPage = new ReservationsLogin(driver);
        final ReservationsHome homePage = new ReservationsHome(driver);
        final ReservationsNewUser newUser = new ReservationsNewUser(driver);


        String timestamp = Long.toString(System.currentTimeMillis());
        String testUsername = "testUser" + timestamp;
        String testPassword = "almafa123";

        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, ADMIN_PW);

        homePage.navigateToNewUser();
        newUser.registerReceptionistUser(testUsername, testPassword);
        loginPage.logout();

        loginPage.loginWithCredentials(testUsername, testPassword);
        Assertions.assertTrue(loginPage.isLogoutButtonPresent());
    }

}
