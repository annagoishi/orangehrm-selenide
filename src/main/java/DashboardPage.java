import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private SelenideElement header = $(byClassName("oxd-topbar-header-breadcrumb-module"));
    public boolean headerIsDisplayed(){
        return header.isDisplayed();
    }

    public SelenideElement getHeader() {
        return header;
    }
}
