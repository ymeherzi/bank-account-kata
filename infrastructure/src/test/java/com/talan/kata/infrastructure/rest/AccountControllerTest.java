package com.talan.kata.infrastructure.rest;

import com.talan.kata.infrastructure.api.AccountService;
import io.javalin.Javalin;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class AccountControllerTest {

    private Javalin server;
    private AccountController controller;
    private AccountService service;

    @Before
    public void setup() {
        RestAssured.port = 7000;
        RestAssured.basePath = "/";
        service = mock(AccountService.class);
        controller = new AccountController(service);
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

        verify(service, times(1)).create("yassine.mehrzi", "eur");
    }


    @After
    public void tearDown() {
        server.stop();
    }
}


