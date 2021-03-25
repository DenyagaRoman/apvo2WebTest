import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AuthorizationTest {
    private AuthorizationPage page;

    @BeforeAll
    public static void setUp() {
      //  Configuration.holdBrowserOpen = true;
        timeout=30000;
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\r.denyaga\\IdeaProjects\\apvo2WebTest\\drivers\\chromedriver.exe");
        browser = "chrome";

      //  System.setProperty("webdriver.gecko.driver", "C:\\Users\\r.denyaga\\IdeaProjects\\apvo2WebTest\\drivers\\geckodriver.exe");
      //  browser="firefox";

      //  System.setProperty("webdriver.ie.driver", "C:\\Users\\r.denyaga\\IdeaProjects\\apvo2WebTest\\drivers\\MicrosoftWebDriver.exe");
      //  browser="ie";

      //  System.setProperty("webdriver.msedge.driver", "C:\\Users\\r.denyaga\\IdeaProjects\\apvo2WebTest\\drivers\\msedgedriver.exe");
       // browser="edge";

        baseUrl = "http://vsrv-oasu-8:9080/wnd_pr";
        //    baseUrl = "http://apvo.gvc.oao.rzd/wnd_pr";
    }

    @Test
    public void authorizationGood() {
        page = new AuthorizationPage();
        page.open()
                .autorization("island-jack","ostrov");
        assertTrue(page.notError());//Assert.assertTrue(page.notError());
    }

    @Test
    public void authorizationError() {
        page = new AuthorizationPage();
        page.open()
                .autorization("ttttt","kkkkkk");
       assertTrue(page.isError()); //Assert.assertTrue(page.isError());
    }

    @AfterEach
   public void end(){
        WebDriverRunner.closeWebDriver();
        WebDriverRunner.clearBrowserCache();
   }
}

