package com.pw.recipeFinder.domain.recipefinder;

import java.util.Optional;

public interface RecipeFinder {
    String findRecipe();
    String findRecipe(String name);
}
