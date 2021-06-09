package test.java;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import main.utils.CaptureRequests;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SampleApiTest extends BaseTest {

    @Test
    public void sampleTestApi(){
        {
            // request the server
            Response response = RestAssured.get("https://api.spacexdata.com/v4/launches/latest");
            // store the response body in string
            String responseBody = response.getBody().asString();
            // print the response
            System.out.println("Response Body is =>  " + responseBody);
            // store the response code
            int responseStatusCode = response.getStatusCode();
            System.out.println("************************************************");
            System.out.println("Status Code => "+ responseStatusCode);
            System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));
        }
    }




}
