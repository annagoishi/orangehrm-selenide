import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class LinkedInPage {
    private SelenideElement popUpText = $(byClassName("contextual-sign-in-modal__join-now"));
    public SelenideElement getPopUpText() {
        return popUpText;
    }
}
