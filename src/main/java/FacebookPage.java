import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class FacebookPage {
    private SelenideElement logo = $(byAttribute("aria-label", "Facebook"));
    public SelenideElement getLogo() {
        return logo;
    }
}
