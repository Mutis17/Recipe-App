@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.recipeapp

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.recipeapp.models.Meal
import com.example.recipeapp.models.SplashViewModel
import com.example.recipeapp.ui.theme.RecipeAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel: SplashViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition{viewModel.isLoading.value}

        setContent {
            RecipeAppTheme {
                MyApp{ meal ->
                    startActivity(ProfileActivity.newIntent(this, meal))
                }
            }
        }
    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApp(navigateToProfile: (Meal) -> Unit) {
    Scaffold (
        content = {
            HomeContent(navigateToProfile = navigateToProfile)
        }
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview(){
    RecipeAppTheme(darkTheme = true) {
        MyApp {}
    }
}