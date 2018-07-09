package com.talan.kata.infrastructure.rest;

import com.talan.kata.infrastructure.api.BankAccount;
import io.javalin.Javalin;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.*;


public class AccountControllerTest {

    private Javalin server;
    private AccountController controller;
    private BankAccount bankAccount;

    @Before
    public void setup() {
        RestAssured.port = 7000;
        RestAssured.basePath = "/";
        bankAccount = mock(BankAccount.class);
        controller = new AccountController(bankAccount);
        server = Javalin.start(7000);
        server.post("/", controller::create);
    }

    @Test
    public void should_create_account() {
        Command command = new Command("yassine.mehrzi", "eur");
        given()
                .contentType("application/json")
                .body(command)
                .when()
                .post("/")
                .then()
                .statusCode(201);

        verify(bankAccount, times(1)).create("yassine.mehrzi", "eur");
    }


    @After
    public void tearDown() {
        server.stop();
    }
}


