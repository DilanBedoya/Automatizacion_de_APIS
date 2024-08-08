package glue;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import steps.PetStoreSteps;

public class PetStoreStepDef {

    @Steps
    private PetStoreSteps petStoreSteps;

    @ParameterType("true|false")
    public boolean booleanType(String value) {
        return Boolean.parseBoolean(value);
    }

    @Given("la url {string} del servicio")
    public void laUrlDelServicio(String url) {
        petStoreSteps.definirUrl(url);
    }

    @When("creo una orden con el id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}, complete {booleanType}")
    public void creoUnaOrdenConElIdPetIdQuantityShipDateStatusComplete(int orderId, int petId, int quantity, String shipDate, String status, boolean complete) {
        petStoreSteps.crearOrden(orderId, petId, quantity, shipDate, status, complete);
    }

    @Then("la respuesta debe tener el status code {int}")
    public void laRespuestaDebeTenerElStatusCode(int statusCode) {
        petStoreSteps.validarStatusCode(statusCode);
    }

    @Then("el body debe contener el id de la orden {int}")
    public void elBodyDebeContenerElIdDeLaOrden(int orderId) {
        petStoreSteps.validarIdDeLaOrden(orderId);
    }

    @When("hago la consulta una orden con ID {int}")
    public void hagoLaConsultaUnaOrdenConID(int id) {
        petStoreSteps.consultarOrdenPorId(id);
    }
}
