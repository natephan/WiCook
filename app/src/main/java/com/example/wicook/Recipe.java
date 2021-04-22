package com.example.wicook;

public class Recipe {
    private String recipeName;
    private String description;
    private int recipeImageId;
    private int recipeRating;

    public Recipe(String recipeName, String description, int recipeImageId, int recipeRating) {
        this.recipeName = recipeName;
        this.description = description;
        this.recipeImageId = recipeImageId;
        this.recipeRating = recipeRating;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getDescription() {
        return description;
    }

    public int getRecipeImageId() {
        return recipeImageId;
    }

    public int getRecipeRating() {
        return recipeRating;
    }
}
