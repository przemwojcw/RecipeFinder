package com.pw.recipeFinder.domain.recipefinder;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultRecipeFinderTest {

    private final RecipeStorage recipeStorage;

    public DefaultRecipeFinderTest() {
        this.recipeStorage = Mockito.mock(RecipeStorage.class);
    }

    @Test
    void shouldReturnRecipe_ForGivenRecipeName() {
        // given
        final var recipeName = "test";
        Mockito.when(recipeStorage.findRecipe(recipeName)).thenReturn("test");

        // when
        var result = new DefaultRecipeFinder(recipeStorage).findRecipe(recipeName);

        // then
        assertThat(result).isEqualTo("test");
    }
}
