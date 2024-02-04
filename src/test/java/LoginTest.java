import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

public class LoginTest extends BaseTest{
    @Test @Category(Smoke.class)
    public void successLogin(){
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        dashboardPage.getHeader().shouldBe(Condition.visible).shouldHave(text("Dashboard"));
    }
    @Test
    public void loginWithInvalidPassword(){
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin1234");
        loginPage.clickOnLoginButton();
        loginPage.getErrorMessage().shouldBe(Condition.visible).shouldHave(text("Invalid credentials"));
    }
    @Test
    public void loginWithNonExistingUser(){
        loginPage.enterUsername("Qwerty");
        loginPage.enterPassword("qwerty1234");
        loginPage.clickOnLoginButton();
        loginPage.getErrorMessage().shouldBe(Condition.visible).shouldHave(text("Invalid credentials"));
    }
    @Test
    public void elementsAreDisplayed(){
        //check that logo is displayed
        loginPage.getLogoImg().shouldBe(Condition.visible);
        loginPage.logoImageIsCorrect();
        loginPage.getCredentials().shouldBe(Condition.visible);
        loginPage.getLinkedinIcon().shouldBe(Condition.visible);
        loginPage.getFacebookIcon().shouldBe(Condition.visible);
        loginPage.getTwitterIcon().shouldBe(Condition.visible);
        loginPage.getYouTubeIcon().shouldBe(Condition.visible);
    }
    @Test
    public void linkedInLinkIsCorrect(){
        loginPage.clickOnLinkedInIcon();
        sleep(2000);
        switchTo().window(1);
        linkedInPage.getPopUpText().shouldHave(text("linkedIn"));
    }
    @Test
    public void facebookLinkIsCorrect(){
        loginPage.clickOnFacebookIcon();
        switchTo().window(1);
        sleep(3000);
        facebookPage.getLogo().shouldBe(Condition.visible);
    }
    @Test
    public void twitterLinkIsCorrect(){
        loginPage.clickOnTwitterIcon();
        switchTo().window(1);
        sleep(15000);
        twitterPage.getTwitterText().shouldBe(Condition.visible);
    }
    @Test
    public void youTubeLinkIsCorrect(){
        loginPage.clickOnYoutubeIcon();
        switchTo().window(1);
        youTubePage.getYouTubeText().shouldHave(text("YouTube"));
    }
    @Test
    public void resetPasswordPage(){
        loginPage.clickOnForgotPasswordButton();
        //Username input field
        resetPasswordPage.getUsernameInputField().shouldBe(Condition.visible);
        //Cancel button
        resetPasswordPage.getCancelButton().shouldBe(Condition.visible);
        //Reset Password button
        resetPasswordPage.getResetPasswordButton().shouldBe(Condition.visible);
    }
    @Test
    public void resetPasswordLinkSending(){
        loginPage.clickOnForgotPasswordButton();
        resetPasswordPage.enterUsername("jack167");
        resetPasswordPage.clickOnResetPasswordButton();
        resetPasswordPage.getResetPasswordTitle().shouldHave(text("Reset Password link sent successfully"));
    }
    @Test
    public void resetPasswordWithoutUsername(){
        loginPage.clickOnForgotPasswordButton();
        resetPasswordPage.clickOnResetPasswordButton();
        resetPasswordPage.getErrorMessage().shouldHave(text("Required"));
    }
}
