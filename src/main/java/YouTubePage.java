import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class YouTubePage {
    private SelenideElement youTubeText = $(byTagName("h1"));
    public SelenideElement getYouTubeText() {
        return youTubeText;
    }
}
