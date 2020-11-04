package com.cmbytes.compose.ui.components

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmbytes.compose.domain.models.Recipe
import com.cmbytes.compose.presentation.navigation.Screen
import com.luca992.compose.image.CoilImage
import com.cmbytes.compose.R

@Composable
fun RecipesScreen(
    items: List<Recipe>,
    navigateTo: (Screen) -> Unit,
) {
    Column(modifier = Modifier.padding(bottom = 10.dp)) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            elevation = 12.dp,
        ) {
            Text(
                text = stringResource(R.string.recipes_title),
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 25.dp, top = 17.dp, bottom = 10.dp)
            )
        }
        val color = remember { Color(0xFF1e000000) }
        Spacer(modifier = Modifier.fillMaxWidth().height(4.dp).background(color = color))
        LazyColumnFor(items = items, modifier = Modifier.padding(top = 10.dp)) { recipe ->
            RecipeCard(
                navigateTo = navigateTo,
                recipe = recipe,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 25.dp, vertical = 10.dp)
            )
        }
    }
}

@Composable
fun RecipeCard(navigateTo: (Screen) -> Unit, recipe: Recipe, modifier: Modifier = Modifier) {
    Card(modifier = modifier, elevation = 6.dp) {
        Box {
            CoilImage(recipe.image)
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
                        color = textColor,
                        modifier = Modifier.padding(end = 12.dp)
                    )
                    Box(
                        modifier = Modifier.padding(top = 2.dp)
                            .background(color = textColor, shape = CircleShape).preferredSize(4.dp)
                    )
                    Text(
                        text = stringResource(R.string.recipes_ingredients),
                        color = textColor,
                        modifier = Modifier.padding(start = 12.dp)
                    )
                    val color = MaterialTheme.colors.secondary
                    RecipeButton(
                        onClick = { navigateTo(Screen.Detail(recipe.id)) },
                        text = "Cook",
                        color = color,
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
                        Triangle(color)
                    }
                }
            }
        }
    }
}

