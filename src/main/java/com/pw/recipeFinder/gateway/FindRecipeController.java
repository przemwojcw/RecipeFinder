package com.pw.recipeFinder.gateway;

import com.pw.recipeFinder.domain.recipefinder.RecipeFinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class FindRecipeController {

    private final RecipeFinder recipeFinder;

    FindRecipeController(RecipeFinder recipeFinder) {
        this.recipeFinder = recipeFinder;
    }

    @GetMapping("/recipe/{name}")
    Recipe getRecipeByName(@PathVariable String name) {
        return new Recipe(recipeFinder.findRecipe(name));
    }

    @PostMapping("/recipe")
    Recipe getRecipe() {
        return new Recipe(recipeFinder.findRecipe());
    }


}
