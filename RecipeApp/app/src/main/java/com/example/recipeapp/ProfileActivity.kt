package com.example.recipeapp

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.recipeapp.models.Meal
import com.example.recipeapp.ui.theme.RecipeAppTheme




@RequiresApi(Build.VERSION_CODES.TIRAMISU)
class ProfileActivity : AppCompatActivity() {

    private val meal: Meal by lazy {
        intent?.getSerializableExtra(MEAL_ID, Meal::class.java) as Meal
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeAppTheme{
                ProfileScreen(meal as Meal)
            }
        }
    }
    companion object{
        private const val MEAL_ID= "meal_id"
        fun newIntent(context: Context, meal: Meal): Intent =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(MEAL_ID, meal)
            }
    }

}
