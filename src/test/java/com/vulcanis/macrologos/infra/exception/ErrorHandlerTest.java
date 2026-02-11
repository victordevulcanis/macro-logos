package com.vulcanis.macrologos.infra.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
class ErrorHandlerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    @BeforeEach
    void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @DisplayName("Should return 400 status when JSON is empty")
    void shouldReturn400WhenJsonIsEmpty() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                post("/api/v1/calculator/bmr")
                        .content("{}")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Should return 400 status when JSON is malformed")
    void shouldReturn400WhenJsonIsMalformed() throws Exception {
        String malformedJson = "{ \"weight\": \"invalid_number\" }";

        MockHttpServletResponse response = mvc.perform(
                post("/api/v1/calculator/bmr")
                        .content(malformedJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}