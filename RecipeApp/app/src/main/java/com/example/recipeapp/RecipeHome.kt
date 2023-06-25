package com.example.recipeapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.recipeapp.models.Meal

@Composable
fun HomeContent(navigateToProfile: (Meal) -> Unit) {
    val meals = remember { Data.recipeList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = meals,
            itemContent = {
                MealListItem(meal = it, navigateToProfile )
            })
    }
}
