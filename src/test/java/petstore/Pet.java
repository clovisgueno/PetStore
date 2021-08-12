//pacote
package petstore;

//bibliotecas
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

//classe
public class Pet {

    //atributos
    String uri = "https://petstore.swagger.io/v2/pet"; //endereço entidade pet

    //metodos e funcoes
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //incluir - create - post
    @Test // Identifica o metodo ou função como um teste para o TestNG
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

        // Sintaxe Gherkin
        // Dado - Quando - Então
        // Given - when - Then

        given()
                .contentType("application/json") // comum em API REST
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200)
        ;


    }

}
