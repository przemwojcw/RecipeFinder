package com.pw.recipeFinder.domain.recipefinder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultRecipeFinderTest {

    @Test
    void shouldReturnRecipeIfExists_ForGivenProducts() {
        // given
        final var product = "";

        // when
        var result = new DefaultRecipeFinder().findRecipe();

        // then
        assertThat(result).isEqualTo("recipe");
    }
}
