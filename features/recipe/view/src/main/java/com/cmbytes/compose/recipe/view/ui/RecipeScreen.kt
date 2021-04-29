package com.cmbytes.compose.recipe.view.ui

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmbytes.compose.recipes.domain.models.ExtendedIngredient
import com.cmbytes.compose.recipes.domain.models.Recipe
import com.cmbytes.compose.recipes.domain.models.Step
import com.cmbytes.compose.recipe.presentation.viewmodels.navigation.models.Section
import com.cmbytes.compose.recipe.presentation.store.RecipeState
import com.cmbytes.compose.recipe.presentation.store.RecipeState.CurrentRecipe
import com.cmbytes.compose.recipe.presentation.viewmodels.navigation.models.Section.*
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun RecipeScreenState(
    recipeState: RecipeState,
    selectedTabIndex: Int,
    navigateTo: (Section) -> Unit,
) {
    when (recipeState) {
        is CurrentRecipe -> RecipeScreen(
            recipeState.recipe,
            selectedTabIndex,
            navigateTo
        )
        else -> Text(text = "Loading")
    }
}

@Composable
fun RecipeScreen(
    recipe: Recipe,
    selectedTabIndex: Int,
    navigateTo: (Section) -> Unit,
) {
    Column(modifier = Modifier.background(color = Color.White).fillMaxHeight()) {
        RecipeBanner(recipe)
        RecipeTabs(recipe, selectedTabIndex) { index ->
            navigateTo(
                when (index) {
                    0 -> Ingredients(index)
                    else -> HowToCook(index)
                }
            )
        }
    }
}

@Composable
fun RecipeBanner(recipe: Recipe) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = rememberCoilPainter(recipe.image),
            contentDescription = "recipe",
            modifier = Modifier.fillMaxWidth().requiredHeight(360.dp)
        )
        Box(
            modifier = Modifier.fillMaxWidth().requiredHeight(360.dp)
                .background(color = Color(0xFF80282928), shape = RectangleShape)
        )
        Text(
            text = recipe.title,
            modifier = Modifier.align(Alignment.BottomStart)
                .padding(start = 25.dp, end = 33.dp, bottom = 15.dp),
            style = TextStyle(color = Color.White, fontSize = 24.sp)
        )
    }
}

@Composable
fun RecipeTabs(
    recipe: Recipe,
    selectedTabIndex: Int,
    onSelected: (Int) -> Unit
) {
    TabRow(
        modifier = Modifier.requiredHeight(50.dp).padding(horizontal = 20.dp),
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.primaryVariant,
        selectedTabIndex = selectedTabIndex
    ) {
        RecipeTab(
            selected = selectedTabIndex == 0,
            onClick = { onSelected(0) },
            text = "Ingredients"
        )
        RecipeTab(
            selected = selectedTabIndex == 1,
            onClick = { onSelected(1) },
            text = "How to Cook"
        )
    }
    
    Crossfade(targetState = selectedTabIndex, animationSpec = tween(3000)) { index ->
        Column(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 16.dp, bottom = 20.dp)
                .wrapContentHeight()
        ) {
            Card(elevation = 6.dp, modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
                when (index) {
                    0 -> IngredientsCard(recipe.extendedIngredients)
                    else -> if (recipe.analyzedInstructions.isNotEmpty()) {
                        InstructionsCard(recipe.analyzedInstructions[0].steps)
                    } else {
                        Text(text = "No data")
                    }
                }
            }
        }
    }
}

@Composable
fun RecipeTab(selected: Boolean, onClick: () -> Unit, text: String) {
    Tab(selected = selected, onClick = onClick) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                color = if (selected) Color.Black else Color(0xFF606060)
            ),
            modifier = Modifier.align(alignment = Alignment.Start).padding(start = 6.dp)
        )
    }
}

@Composable
fun IngredientsCard(ingredients: List<ExtendedIngredient>) {
    LazyColumn(modifier = Modifier.padding(14.dp)) {
        items(ingredients) {
            Ingredient(it.image, it.name)
        }
    }
}

@Composable
fun Ingredient(image: String, name: String) {
    Row(modifier = Modifier.padding(bottom = 20.dp)) {
        Image(
            painter = rememberCoilPainter("https://spoonacular.com/cdn/ingredients_100x100/$image"),
            contentDescription = "recipe",
            modifier = Modifier.height(50.dp).width(50.dp).clip(CircleShape).clipToBounds()
        )
        Text(
            text = name,
            modifier = Modifier.padding(start = 16.dp).align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun InstructionsCard(instructions: List<Step>) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(items = instructions) { instruction ->
            Instruction(instruction.number.toString(), instruction.step)
        }
    }
}

@Composable
fun Instruction(number: String, description: String) {
    Row(modifier = Modifier.padding(bottom = 20.dp)) {
        Text(
            text = number,
            style = TextStyle(
                fontSize = 12.sp,
                color = MaterialTheme.colors.secondary,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.height(20.dp).width(20.dp)
                .border(1.dp, MaterialTheme.colors.secondary, shape = CircleShape)
                .align(Alignment.Top),
        )
        Text(
            text = description,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.padding(start = 16.dp).align(Alignment.CenterVertically)
        )
    }
}