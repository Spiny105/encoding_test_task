package encoding.steps;

import encoding.GettingStartedPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GettingStartedPageSteps {

    private GettingStartedPage gettingStartedPage;

    public GettingStartedPageSteps(WebDriver driver){
        gettingStartedPage = PageFactory.initElements(driver, GettingStartedPage.class);
    }

    public void search(String inputString){
        gettingStartedPage.search(inputString);
    }

    public void goToGetStatusExtendedPage(){
        gettingStartedPage.goToGetStatusExtendedPage();
    }
}
