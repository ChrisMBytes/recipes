package com.cmbytes.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.animation.Crossfade
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.cmbytes.compose.recipes.presentation.viewmodels.RecipesViewModel
import com.cmbytes.compose.recipes.presentation.viewmodels.navigation.ScreenNavigationViewModel
import com.cmbytes.compose.recipes.presentation.viewmodels.navigation.models.Screen.*
import com.cmbytes.compose.recipe.presentation.viewmodels.RecipeViewModel
import com.cmbytes.compose.recipe.presentation.viewmodels.navigation.SectionNavigationViewModel
import com.cmbytes.compose.recipe.view.ui.RecipeScreenState
import com.cmbytes.compose.recipes.view.ui.RecipesScreen
import com.cmbytes.compose.recipes.view.ui.themes.RecipeTheme
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var recipesViewModel: RecipesViewModel

    @Inject
    lateinit var screenNavigationViewModel: ScreenNavigationViewModel

    @Inject
    lateinit var recipeViewModel: RecipeViewModel

    @Inject
    lateinit var sectionNavigationViewModel: SectionNavigationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            RecipeTheme {
                ScreenContent()
            }
        }
    }

    override fun onBackPressed() {
        screenNavigationViewModel.onBack()
    }

    @Composable
    private fun ScreenContent() {
        Crossfade(screenNavigationViewModel.currentScreen) { screen ->
            when (screen) {
                is Home -> RecipesScreen(
                    recipesViewModel.recipes,
                    screenNavigationViewModel::navigateTo
                )
                is Detail -> {
                    recipeViewModel.load(screen.recipeId)
                    RecipeScreenState(
                        recipeViewModel.recipeState,
                        sectionNavigationViewModel.section.id,
                        sectionNavigationViewModel::navigateTo
                    )
                }
            }
        }
    }
}