package com.pw.recipeFinder.domain.recipefinder;

class DefaultRecipeFinder implements RecipeFinder {
    private final RecipeStorage recipeStorage;

    DefaultRecipeFinder(RecipeStorage recipeStorage) {
        this.recipeStorage = recipeStorage;
    }

    @Override
    public String findRecipe(String name) {
        return recipeStorage.findRecipe(name);
    }
}
