package encoding.steps;

import encoding.GetStatusPage;
import encoding.utils.JSONPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GetStatusPageSteps {

    private GetStatusPage getStatusPage;

    public GetStatusPageSteps(WebDriver driver){
        getStatusPage = PageFactory.initElements(driver, GetStatusPage.class);
    }

    public void switchResponceFrameToJson() {
        getStatusPage.switchResponceFrameToJson();
    }

    public void checkResponceJson() {
        String jsonString = "";
        try {
            jsonString = getStatusPage.getResponceFrameText();
            String status = (new JSONPath("response.job[0].format[0].status").getWithin(jsonString)).get();
            Assert.assertEquals(status,"Status");
            String processor = (new JSONPath("response.job[0].processor").getWithin(jsonString)).get();
            Assert.assertTrue(processor.contains("AMAZON"), "field processor doesn't contains word AMAZON");
            Assert.assertTrue(processor.contains("RACKSPACE"), "field processor doesn't contains word RACKSPACE");
        }
        catch (Exception e)
        {
            Assert.fail(e.toString());
        }
    }

}
