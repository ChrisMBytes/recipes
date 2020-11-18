package com.cmbytes.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import com.cmbytes.compose.presentation.viewmodels.navigation.models.Screen
import com.cmbytes.compose.recipes.presentation.viewmodels.RecipesViewModel
import com.cmbytes.compose.presentation.viewmodels.navigation.ScreenNavigationViewModel
import com.cmbytes.compose.recipe.presentation.viewmodels.RecipeViewModel
import com.cmbytes.compose.recipe.presentation.viewmodels.SectionNavigationViewModel
import com.cmbytes.compose.ui.components.RecipeScreenState
import com.cmbytes.compose.ui.components.RecipesScreen
import com.cmbytes.compose.ui.themes.RecipeTheme
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

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
                is Screen.Home -> RecipesScreen(
                    recipesViewModel.recipes,
                    screenNavigationViewModel::navigateTo
                )
                is Screen.Detail -> {
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