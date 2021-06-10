    package test.java;

    import com.jayway.restassured.RestAssured;
    import com.jayway.restassured.response.Response;
    import org.testng.Assert;
    import org.testng.annotations.Test;
    import java.io.IOException;
    import java.net.HttpURLConnection;
    import java.net.URL;
    import java.util.concurrent.TimeUnit;

    public class SampleApiTest extends BaseTest {

        @Test
        public void getUrlData() throws IOException
            {
                driver.navigate().to("https://github.com/r-spacex/SpaceX-API");

                // request the server
                Response response = RestAssured.get("https://api.spacexdata.com/v4/launches/latest");
                // store the response body in string
                String responseBody = response.getBody().asString();
                // print the response
                System.out.println("Response Body is =>  " + responseBody);
                Assert.assertTrue(responseBody.contains("ships"));
            }

        @Test
        public void getLoadTime(){
            // request the server
            Response response = RestAssured.get("https://api.spacexdata.com/v4/launches/latest");
            // store the response code
            int responseStatusCode = response.getStatusCode();
            long startTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("************************************************");
            System.out.println("Status Code => " + responseStatusCode);
            System.out.println("Total Page Load Time: " + response.getTimeIn(TimeUnit.MILLISECONDS));

        }

            @Test
            public void oKStatusCode() throws IOException {
                HttpURLConnection c =
                        (HttpURLConnection) new
                                URL("https://api.spacexdata.com/v4/launches/latest")
                                .openConnection();
                // set the HEAD request with setRequestMethod
                c.setRequestMethod("HEAD");
                // connection started and get response code
                c.connect();
                int r = c.getResponseCode();
                System.out.println("Http response code: " + r);
                if (c.getResponseCode() == 200) {
                    System.out.println("Success");
                }
            }

            @Test
            public void urlnotFound() throws IOException {
            HttpURLConnection c =
                    (HttpURLConnection) new
                            URL("https://api.spacexdata.com/v4/launches/latest/1")
                            .openConnection();
            // set the HEAD request with setRequestMethod
                c.setRequestMethod("HEAD");
                // connection started and get response code
                c.connect();
                int r = c.getResponseCode();
                System.out.println("Http response code: " + r);
                if(c.getResponseCode() != 200)
                {
                    System.out.println("Success");
                }

            }


       }
