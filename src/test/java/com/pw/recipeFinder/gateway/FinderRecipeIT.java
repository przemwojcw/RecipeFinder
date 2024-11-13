package com.pw.recipeFinder.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = { "app.environment=integrationTest" })
@AutoConfigureMockMvc
class FinderRecipeIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnRecipeForGivenName() throws Exception {
        // given
        final var recipeName = "testName";

        //when
        MvcResult result = this.mockMvc.perform(get("/recipe/"+recipeName))
                .andExpect(status().isOk())
                .andReturn();

        // then
        final var recipe = getBody(result, Recipe.class);
        assertThat(recipe.text()).isEqualTo("testName");
    }

    private <T> T getBody(MvcResult result, Class<T> type) throws JsonProcessingException, UnsupportedEncodingException {
        return objectMapper.readValue(result.getResponse().getContentAsString(), type);
    }
}
