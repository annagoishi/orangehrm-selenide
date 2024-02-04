import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement usernameInputField = $("[name='username']");
    private SelenideElement passwordInputField = $("[name='password']");
    private SelenideElement passwordForgotButton = $(byClassName("orangehrm-login-forgot-header"));
    private SelenideElement loginButton = $("[type='submit']");
    private SelenideElement errorMessage = $(byClassName("oxd-alert-content-text"));
    private SelenideElement credentials = $(byClassName("orangehrm-demo-credentials"));
    private SelenideElement logoImg = $(byAttribute("alt", "company-branding"));
    private SelenideElement linkedinIcon = $(byXpath("//a[contains(@href,'linkedin')]"));
    private SelenideElement facebookIcon = $(byXpath("//a[contains(@href,'facebook')]"));
    private SelenideElement twitterIcon = $(byXpath("//a[contains(@href,'twitter')]"));
    private SelenideElement youTubeIcon = $(byXpath("//a[contains(@href,'youtube')]"));

    public SelenideElement getFacebookIcon() {
        return facebookIcon;
    }

    public SelenideElement getTwitterIcon() {
        return twitterIcon;
    }

    public SelenideElement getYouTubeIcon() {
        return youTubeIcon;
    }

    public SelenideElement getLinkedinIcon() {
        return linkedinIcon;
    }

    public SelenideElement getCredentials() {
        return credentials;
    }

    public void enterUsername(String usernameValue){
        usernameInputField.shouldBe(visible, Duration.ofSeconds(10000));
        usernameInputField.setValue(usernameValue);
    }
    public void enterPassword(String passwordValue){
        passwordInputField.setValue(passwordValue);
    }
    public void clickOnLoginButton(){
        loginButton.click();
    }
    public void clickOnForgotPasswordButton(){
        passwordForgotButton.click();
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }

    public SelenideElement getLogoImg() {
        return logoImg;
    }
    public void logoImageIsCorrect(){
        logoImg.shouldHave(Condition.attributeMatching("src", ".*ohrm_branding.png.*"));
    }
    public void clickOnLinkedInIcon(){
        linkedinIcon.click();
    }
    public void clickOnFacebookIcon(){
        facebookIcon.click();
    }
    public void clickOnTwitterIcon(){
        twitterIcon.click();
    }
    public void clickOnYoutubeIcon(){
        youTubeIcon.click();
    }
    public void successLogin(String usernameValue, String passwordValue){
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(usernameValue);
        loginPage.enterPassword(passwordValue);
        loginPage.clickOnLoginButton();
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.getHeader().shouldBe(Condition.visible).shouldHave(text("Dashboard"));
    }
}
