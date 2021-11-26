package encoding;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GettingStartedPage extends BasePage {

    @FindBy(partialLinkText = "GetStatus (extended)")
    protected WebElement getStatusExtendedResult;

    public void goToGetStatusExtendedPage()
    {
        getStatusExtendedResult.click();
    }
}
