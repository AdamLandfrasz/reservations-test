package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.*;

public class NewUser extends BaseTest {
    final ReservationsLogin loginPage = new ReservationsLogin(driver);
    final ReservationsHome homePage = new ReservationsHome(driver);
    final ReservationsNewUser newUser = new ReservationsNewUser(driver);

    @AfterEach
    void logoutAfterTest() {
        if (loginPage.isLogoutButtonPresentNoWait()) {
            loginPage.logout();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"RECEPTIONIST", "ADMIN"})
    void registerValidUser(String role){

        String timestamp = Long.toString(System.currentTimeMillis());
        String testUsername = "testUser" + timestamp;
        String testPassword = "almafa123";

        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, ADMIN_PW);

        newUser.navigateToNewUser();
        newUser.registerUser(testUsername, testPassword, role);
        loginPage.logout();

        loginPage.loginWithCredentials(testUsername, testPassword);
        Assertions.assertTrue(loginPage.isLogoutButtonPresent());
    }

    @Disabled
    @Test
    void registerUserWithoutRole(){

        String timestamp = Long.toString(System.currentTimeMillis());
        String testUsername = "testUser" + timestamp;
        String testPassword = "almafa123";

        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(ADMIN_USERNAME, ADMIN_PW);

        newUser.navigateToNewUser();
        newUser.registerUserWithoutRole(testUsername, testPassword);
        loginPage.logout();

        loginPage.loginWithCredentials(testUsername, testPassword);
        Assertions.assertTrue(loginPage.isLogoutButtonPresent());
    }

    @Test
    void checkReceptionistAddUserUrlAvailability(){

        loginPage.navigateToLogin();
        loginPage.loginWithCredentials(RECEPTIONIST_USERNAME, RECEPTIONIST_PW);

        newUser.goToAddUserURL();

        Assertions.assertFalse(driver.getCurrentUrl().endsWith("adduser"));
    }

}
