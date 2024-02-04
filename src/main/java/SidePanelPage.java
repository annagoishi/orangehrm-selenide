import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SidePanelPage {
    private ElementsCollection links = $$(byClassName("oxd-main-menu-item-wrapper"));
    private SelenideElement admin = $$(byClassName("oxd-main-menu-item-wrapper")).get(0);
    private SelenideElement sidePanel = $(byClassName("oxd-sidepanel"));
    private SelenideElement menuButton = $(byClassName("oxd-main-menu-button"));
    private SelenideElement logoBig = $("[alt='client brand banner']");
    private SelenideElement logoSmall = $("[alt='client brand logo']");
    private SelenideElement searchField = $(byClassName("oxd-input--active"));
    private SelenideElement pim = $$(byClassName("oxd-main-menu-item-wrapper")).get(1);
    private SelenideElement leave = $$(byClassName("oxd-main-menu-item-wrapper")).get(2);
    private SelenideElement time = $$(byClassName("oxd-main-menu-item-wrapper")).get(3);
    private SelenideElement recruitment = $$(byClassName("oxd-main-menu-item-wrapper")).get(4);
    private SelenideElement myInfo = $$(byClassName("oxd-main-menu-item-wrapper")).get(5);
    private SelenideElement performance = $$(byClassName("oxd-main-menu-item-wrapper")).get(6);
    private SelenideElement dashboard = $$(byClassName("oxd-main-menu-item-wrapper")).get(7);
    private SelenideElement directory = $$(byClassName("oxd-main-menu-item-wrapper")).get(8);
    private SelenideElement maintenance = $$(byClassName("oxd-main-menu-item-wrapper")).get(9);
    private SelenideElement claim = $$(byClassName("oxd-main-menu-item-wrapper")).get(10);
    private SelenideElement buzz = $$(byClassName("oxd-main-menu-item-wrapper")).get(11);
    private ElementsCollection visibleElements = $$(By.cssSelector(".oxd-main-menu-item-wrapper"));
    private ElementsCollection availableLinksNames = $$(byClassName("oxd-main-menu-item"));
    public void checkAllCorrectCollectionTexts(List<String> expected){
        availableLinksNames.shouldHave(textsInAnyOrder(expected));
    }
    public void checkLinksAmount(){
        links.shouldHave(CollectionCondition.size(12));
    }
    public SelenideElement getLeave() {
        return leave;
    }
    public ElementsCollection getLinks() {
        return links;
    }
    public SelenideElement getSearchField() {
        return searchField;
    }

    public ElementsCollection getVisibleElements() {
        return visibleElements;
    }

    public SelenideElement getSidePanel() {
        return sidePanel;
    }

    public SelenideElement getTime() {
        return time;
    }

    public SelenideElement getDashboard() {
        return dashboard;
    }

    public SelenideElement getRecruitment() {
        return recruitment;
    }

    public SelenideElement getMyInfo() {
        return myInfo;
    }

    public SelenideElement getPerformance() {
        return performance;
    }

    public SelenideElement getDirectory() {
        return directory;
    }

    public SelenideElement getMaintenance() {
        return maintenance;
    }

    public SelenideElement getClaim() {
        return claim;
    }

    public SelenideElement getBuzz() {
        return buzz;
    }

    public SelenideElement getPim() {
        return pim;
    }

    public SelenideElement getAdmin() {
        return admin;
    }
    public void clickOnSearchField(){
        searchField.click();
    }
    public void clickOnMenuButton(){
        menuButton.click();
    }
    public void enterSearchText(String searchValue){
        searchField.setValue(searchValue);
    }
    public SelenideElement getMenuButton() {
        return menuButton;
    }
    public SelenideElement getLogoBig() {
        return logoBig;
    }
    public SelenideElement getLogoSmall() {
        return logoSmall;
    }
}
