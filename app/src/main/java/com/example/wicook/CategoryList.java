package com.example.wicook;

import java.io.Serializable;

public class CategoryList implements Serializable {

    public String categoryName;


    public CategoryList() {

    }

    public CategoryList(String categoryName) {
        this.categoryName = categoryName;

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
