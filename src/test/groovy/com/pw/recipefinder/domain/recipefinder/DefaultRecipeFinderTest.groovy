package com.pw.recipefinder.domain.recipefinder

import com.pw.recipeFinder.domain.recipefinder.DefaultRecipeFinder
import com.pw.recipeFinder.domain.recipefinder.RecipeStorage
import spock.lang.Specification

class DefaultRecipeFinderTest extends Specification {
    private RecipeStorage recipeStorage

    def setup() {
        this.recipeStorage = Mock(RecipeStorage.class)
    }

    def "should return recipe for given recipe name"() {
        given:
            final var recipeName = "test";
            recipeStorage.findRecipe(recipeName) >> "test"
        when:
            var result = new DefaultRecipeFinder(recipeStorage).findRecipe(recipeName)
        then:
            result == "test"
    }
}
