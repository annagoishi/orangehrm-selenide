import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.cssClass;
import static java.util.Arrays.asList;


public class SidePanelTest extends BaseTest {
    @Test
    public void allLinksAreDisplayed(){
        loginPage.successLogin("Admin", "admin123");
        sidePanelPage.getAdmin().shouldHave(Condition.text("Admin"));
        sidePanelPage.getPim().shouldHave(Condition.text("PIM"));
        sidePanelPage.getLeave().shouldHave(Condition.text("Leave"));
        sidePanelPage.getTime().shouldHave(Condition.text("Time"));
        sidePanelPage.getRecruitment().shouldHave(Condition.text("Recruitment"));
        sidePanelPage.getMyInfo().shouldHave(Condition.text("My Info"));
        sidePanelPage.getPerformance().shouldHave(Condition.text("Performance"));
        sidePanelPage.getDashboard().shouldHave(Condition.text("Dashboard"));
        sidePanelPage.getDirectory().shouldHave(Condition.text("Directory"));
        sidePanelPage.getMaintenance().shouldHave(Condition.text("Maintenance"));
        sidePanelPage.getClaim().shouldHave(Condition.text("Claim"));
        sidePanelPage.getBuzz().shouldHave(Condition.text("Buzz"));
    }
    @Test @Category(Smoke.class)
    public void searchExactLink(){
        //implementation
        loginPage.successLogin("Admin", "admin123");
        sidePanelPage.clickOnSearchField();
        sidePanelPage.enterSearchText("Admin");
        sidePanelPage.getVisibleElements().shouldBe(CollectionCondition.size(1)).shouldHave(CollectionCondition.texts("Admin"));

    }
    @Test
    public void checkExpandCollapseSidePanel(){
        List<String> expectedTextLinks = new ArrayList<>(asList("Admin","PIM",  "Leave","Time",
                "Recruitment", "My Info", "Performance", "Dashboard", "Directory", "Maintenance",
                "Claim", "Buzz"));
        loginPage.successLogin("Admin", "admin123");
        sidePanelPage.getSidePanel().shouldNotHave(cssClass("toggled"));
        sidePanelPage.getLogoBig().shouldBe(Condition.visible);
        sidePanelPage.getLogoSmall().shouldBe(Condition.not(Condition.visible));
        sidePanelPage.checkAllCorrectCollectionTexts(expectedTextLinks);
        sidePanelPage.clickOnMenuButton();
        sidePanelPage.getSidePanel().shouldHave(cssClass("toggled"));
        sidePanelPage.getLogoSmall().shouldBe(Condition.visible);
        sidePanelPage.getLogoBig().shouldBe(Condition.not(Condition.visible));
    }
}
