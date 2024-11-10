package com.pw.recipeFinder.domain.recipefinder;

class DefaultRecipeFinder implements RecipeFinder {
    @Override
    public String findRecipe() {
        return "recipe";
    }

    @Override
    public String findRecipe(String name) {
        return "";
    }
}
