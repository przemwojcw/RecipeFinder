package com.pw.recipefinder.gateway

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.pw.recipeFinder.RecipeFinderApplication
import com.pw.recipeFinder.domain.recipefinder.DefaultRecipeFinder
import com.pw.recipeFinder.domain.recipefinder.RecipeStorage
import com.pw.recipeFinder.gateway.Recipe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(classes = RecipeFinderApplication.class, properties = ["app.environment=integrationTest"])
@AutoConfigureMockMvc
class FinderRecipeIT extends TestInfrastructure {

    @Autowired
    private MockMvc mockMvc

    @Autowired
    private ObjectMapper objectMapper

    def "should return recipe for given name"() throws Exception {
        given:
        final var recipeName = "testName"
        when:
        MvcResult result = this.mockMvc.perform(get("/recipe/"+recipeName))
                .andExpect(status().isOk())
                .andReturn()

        then:
        final var recipe = getBody(result, Recipe.class)
        recipe.text() == "testRedis"
    }

    private <T> T getBody(MvcResult result, Class<T> type) throws JsonProcessingException, UnsupportedEncodingException {
        return objectMapper.readValue(result.getResponse().getContentAsString(), type);
    }
}
