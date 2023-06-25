package com.example.recipeapp.models

import java.io.Serializable

data class Meal(
    val id: Int,
    val title: String,
    val prep: String,
    val description: String,
    val ingredients: String,
    val steps: String,
    val mealImageId: Int = 0
) : Serializable
