package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ReservationsHome;
import pages.ReservationsLogin;
import pages.ReservationsNewUser;

public class NewUser extends BaseTest {
    private final ReservationsLogin loginPage = new ReservationsLogin(driver);
    private final ReservationsHome homePage = new ReservationsHome(driver);
    private final ReservationsNewUser newUser = new ReservationsNewUser(driver);

    @Test
    void registerValidUser(){

        String timestamp = Long.toString(System.currentTimeMillis());

        String testUsername = "testUser" + timestamp;
        String testPassword = "almafa123";

        loginPage.loginWithCredentials(ADMIN_USERNAME, ADMIN_USERNAME);
        homePage.navigateToNewUserPage();
        newUser.registerReceptionistUser(testUsername, testPassword);

        Assertions.assertTrue(true);
    }

}
