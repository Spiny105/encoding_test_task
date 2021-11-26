package encoding;

import encoding.steps.GetStatusPageSteps;
import encoding.steps.GettingStartedPageSteps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class UiTest extends BaseTest{

    protected void waitPageForLoad(String expectedUrl, int loadTimeout){
        WebDriverWait wait = new WebDriverWait(driver, loadTimeout);
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @Test
    public void testScenario(){

        GettingStartedPageSteps gettingStartedPageSteps = new GettingStartedPageSteps(driver);

        gettingStartedPageSteps.search("getStatus");
        gettingStartedPageSteps.goToGetStatusExtendedPage();
        waitPageForLoad("https://api.encoding.com/reference#responses-getstatus-extended", 10);

        GetStatusPageSteps getStatusPageSteps = new GetStatusPageSteps(driver);
        getStatusPageSteps.switchResponceFrameToJson();
        getStatusPageSteps.checkResponceJson();
    }
}
