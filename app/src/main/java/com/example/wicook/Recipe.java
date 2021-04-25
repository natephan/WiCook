package com.example.wicook;

public class Recipe{
    private String recipeName;
    private String description;
    private int recipeImageId;
    private int recipeRating;
    private String category;
    private String instructions;
    private String ingredients;
    private String information;
    public int id;

    public Recipe(String recipeName, String description, int recipeImageId, int recipeRating, int id){
        this.recipeName = recipeName;
        this.description = description;
        this.recipeImageId = recipeImageId;
        this.recipeRating = recipeRating;
        this.category = "";
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInformation() {
        return information;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRecipeName(String name) { this.recipeName = name; }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecipeImageId(int recipeImageId) {
        this.recipeImageId = recipeImageId;
    }

    public void setRecipeRating(int recipeRating) {
        this.recipeRating = recipeRating;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
