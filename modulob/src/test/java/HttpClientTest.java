import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientTest {

    @Test
    public void methodTest() {

        try {

            // Arrange
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://postman-echo.com/get"))
                    .GET()
                    .build();

            // Act
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Assert
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body: " + response.body());

        } catch (Exception e) {
            Assert.fail("************ Excepction ************");
        }

    }

}
