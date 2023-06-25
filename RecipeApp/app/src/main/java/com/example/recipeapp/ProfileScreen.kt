package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.recipeapp.models.Meal as Meal1

@Composable
fun ProfileScreen(meal: Meal1) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    ProfileHeader(
                        meal, this@BoxWithConstraints.maxHeight
                    )
                    ProfileContent(meal, this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }
}
@Composable
private fun ProfileHeader(
    meal: Meal1,
    containerHeight: Dp
) {
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = painterResource(id = meal.mealImageId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(meal: Meal1, containerHeight: Dp) {
    Column{
        Title(meal)
        ProfileProperty(stringResource(R.string.prep), meal.prep )
        ProfileProperty(stringResource(R.string.description), meal.description )
        ProfileProperty(stringResource(R.string.ingredients), meal.ingredients )
        ProfileProperty(stringResource(R.string.steps), meal.steps )

        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
private fun Title(
    meal: Meal1
) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Title(
            meal = meal,
            modifier = Modifier.height(32.dp)
        )
    }
}
@Composable
private fun Title(meal: Meal1, modifier: Modifier = Modifier) {
    Text(
        text = meal.title,
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Bold)
}
@Composable
fun ProfileProperty(label: String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 10.dp))
        Text(
            text = label,
            modifier = Modifier.height(24.dp),
            style = MaterialTheme.typography.bodySmall,
        )
        Box (
            modifier = Modifier
                .height(30.dp)
                .verticalScroll(rememberScrollState())
                )
        Text(
            text = value,
            //modifier = Modifier.height(100.dp),
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Visible
        )
    }
}

/*@Preview
@Composable
fun ProfilePreview() {
    val meal = Data.recipeList
    ProfileScreen(meal = meal)
}*/



