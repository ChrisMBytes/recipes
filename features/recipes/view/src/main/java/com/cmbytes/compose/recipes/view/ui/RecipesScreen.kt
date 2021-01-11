package com.cmbytes.compose.recipes.view.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmbytes.compose.recipes.domain.models.Recipe
import com.cmbytes.compose.recipes.presentation.viewmodels.navigation.models.Screen
import com.cmbytes.compose.recipes.presentation.viewmodels.navigation.models.Screen.*
import com.cmbytes.compose.recipes.view.R
import com.cmbytes.compose.recipes.view.ui.components.RecipeButton
import com.cmbytes.compose.recipes.view.ui.components.RecipeTitle
import com.cmbytes.compose.recipes.view.ui.components.Triangle
import dev.chrisbanes.accompanist.coil.*

@Composable
fun RecipesScreen(
    items: List<Recipe>,
    navigateTo: (Screen) -> Unit,
) {
    Column(modifier = Modifier.background(color = Color.White)) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            elevation = 12.dp,
        ) {
            Text(
                text = stringResource(R.string.recipes_title),
                style = TextStyle(fontSize = 24.sp),
                modifier = Modifier.padding(start = 25.dp, top = 17.dp, bottom = 10.dp)
            )
        }
        val color = remember { Color(0xFF1e000000) }
        Spacer(modifier = Modifier.fillMaxWidth().height(4.dp).background(color = color))
        LazyColumn(modifier = Modifier.padding(top = 10.dp)) {
            items(items) {
                RecipeCard(
                    navigateTo = navigateTo,
                    recipe = it,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 25.dp, vertical = 10.dp)
                )
            }
        }
    }
}

@Composable
fun RecipeCard(navigateTo: (Screen) -> Unit, recipe: Recipe, modifier: Modifier = Modifier) {
    Card(modifier = modifier, elevation = 6.dp) {
        Box {
            CoilImage(data = recipe.image, modifier = Modifier.fillMaxWidth().height(230.dp))
            Column(Modifier.background(Color.White).height(120.dp).align(Alignment.BottomCenter)) {
                RecipeTitle(recipe.title)
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 17.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val textColor = remember { Color(0xFF606060) }
                    Text(
                        text = "± " + recipe.readyInMinutes + " mins",
                        style = TextStyle(color = textColor),
                        modifier = Modifier.padding(end = 12.dp)
                    )
                    Box(
                        modifier = Modifier.padding(top = 2.dp)
                            .background(color = textColor, shape = CircleShape).preferredSize(4.dp)
                    )
                    Text(
                        text = stringResource(R.string.recipes_ingredients),
                        style = TextStyle(color = textColor),
                        modifier = Modifier.padding(start = 12.dp)
                    )
                    RecipeCardButton(navigateTo, recipe)
                }
            }
        }
    }
}

@Composable
fun RecipeCardButton(navigateTo: (Screen) -> Unit, recipe: Recipe) {
    val color = MaterialTheme.colors.secondary
    RecipeButton(
        onClick = { navigateTo(Detail(recipe.id)) },
        text = "Cook",
        color = color,
        modifier = Modifier.padding(start = 12.dp)
    ) {
        Triangle(color)
    }
}

