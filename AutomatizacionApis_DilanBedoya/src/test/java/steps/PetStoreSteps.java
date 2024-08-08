package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PetStoreSteps {

    private Response response;
    private String baseUrl;
    private static final String URL = "https://petstore.swagger.io/v2/store/order";
    public void definirUrl(String url) {
        System.out.println("ESCENARIO 1");
        baseUrl = url;
        RestAssured.baseURI = url;
    }

    public void crearOrden(int orderId, int petId, int quantity, String shipDate, String status, boolean complete) {

        String order = "{ \"id\": " + orderId + ", \"petId\": " + petId + ", \"quantity\": " + quantity + ", \"shipDate\": \"" + shipDate + "\", \"status\": \"" + status + "\", \"complete\": " + complete + " }";
        response = given()
                .header("Content-Type", "application/json")
                .body(order)
                .log().all()
                .post(URL);

    }

    public void validarStatusCode(int statusCode) {

        response.then().statusCode(statusCode);


    }

    public void validarIdDeLaOrden(int orderId) {
        assertThat(response.jsonPath().getInt("id"), equalTo(orderId));
    }

    public void consultarOrdenPorId(int id) {
        System.out.println("ESCENARIO 2");
        response = given()
                .pathParam("orderId", id)
                .log().all()
                .get(URL+"/"+"{orderId}");

    }
}
