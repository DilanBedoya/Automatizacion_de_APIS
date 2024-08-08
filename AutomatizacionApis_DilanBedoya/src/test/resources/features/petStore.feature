@features

Feature: Store API Testing

  @petStoreOrder
  Scenario Outline: Crear y Consultar una Orden
    Given la url "https://petstore.swagger.io/v2/store/order" del servicio
    When creo una orden con el id <id>, petId <petId>, quantity <quantity>, shipDate "<shipDate>", status "<status>", complete <complete>
    Then la respuesta debe tener el status code 200
    And el body debe contener el id de la orden <id>

    When hago la consulta una orden con ID <id>
    Then la respuesta debe tener el status code 200
    And el body debe contener el id de la orden <id>

    Examples:
      | id | petId | quantity | shipDate                      | status  | complete |
      | 1  | 1   | 1        | 2024-08-08T00:54:31.041+0000  | placed  | true     |


