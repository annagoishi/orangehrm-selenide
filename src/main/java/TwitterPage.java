import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TwitterPage {
    private SelenideElement twitterText = $(byText("New to X?"));
    public SelenideElement getTwitterText() {
        return twitterText;
    }
}
