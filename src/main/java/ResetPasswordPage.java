import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class ResetPasswordPage {
    private SelenideElement usernameInputField = $(byClassName("oxd-input"));
    private SelenideElement cancelButton = $(byClassName("orangehrm-forgot-password-button--cancel"));
    private SelenideElement resetPasswordButton = $(byClassName("orangehrm-forgot-password-button--reset"));
    private SelenideElement resetPasswordTitle = $(byClassName("orangehrm-forgot-password-title"));
    private SelenideElement errorMessage = $(byClassName("oxd-input-field-error-message"));

    public SelenideElement getResetPasswordTitle() {
        return resetPasswordTitle;
    }

    public SelenideElement getErrorMessage() {
        return errorMessage;
    }

    public String enterUsername (String usernameValue){
        getUsernameInputField().setValue(usernameValue);
        return usernameValue;
    }
    public SelenideElement getUsernameInputField() {
        return usernameInputField;
    }

    public SelenideElement getCancelButton() {
        return cancelButton;
    }

    public SelenideElement getResetPasswordButton() {
        return resetPasswordButton;
    }
    public void clickOnResetPasswordButton(){
        resetPasswordButton.click();
    }
}
