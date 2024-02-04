import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    LoginPage loginPage = new LoginPage();
    SidePanelPage sidePanelPage = new SidePanelPage();
    DashboardPage dashboardPage = new DashboardPage();
    LinkedInPage linkedInPage = new LinkedInPage();
    FacebookPage facebookPage = new FacebookPage();
    TwitterPage twitterPage = new TwitterPage();
    YouTubePage youTubePage = new YouTubePage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    @Before
    public void setUp(){
        Configuration.timeout = 7000;
        Configuration.headless = false;
        Configuration.fastSetValue = true;
        open(BASE_URL);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @After
    public void tearDown(){
        closeWebDriver();
    }
}
