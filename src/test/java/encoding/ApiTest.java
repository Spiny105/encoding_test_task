package encoding;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.MatcherAssert.assertThat;

import static io.restassured.RestAssured.when;
import io.restassured.response.Response;

public class ApiTest {

    private final int SECONDS_IN_DAY = 86400;

    @Test
    public void xmlTest(){
        Response r = when().get("https://status.encoding.com/status.php?format=xml");
        Assert.assertEquals(r.xmlPath().get("response.status").toString(), "Ok");
        assertThat(r.xmlPath().getInt("response.incident_count.lastYear"), lessThan(10));
        assertThat(r.xmlPath().getInt("response.uptime"), greaterThan(86400));
    }

    @Test
    public void jsonTest(){
        Response r = when().get("https://status.encoding.com/status.php?format=json");
        Assert.assertEquals(r.jsonPath().get("status").toString(), "Ok");
        assertThat(r.jsonPath().getInt("incident_count.lastYear"), lessThan(10));
        assertThat(r.jsonPath().getInt("uptime"), greaterThan(SECONDS_IN_DAY));
    }

}
