package com.cmbytes.compose.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cmbytes.compose.MainActivity
import com.cmbytes.compose.general.coroutines.CoroutineDispatchers
import com.cmbytes.compose.general.coroutines.CoroutineDispatchersProvider
import com.cmbytes.compose.recipes.domain.usecases.GetRecipes
import com.cmbytes.compose.recipe.proxy.RecipesProxy
import com.cmbytes.compose.recipe.proxy.RecipesProxyImpl
import com.cmbytes.compose.presentation.store.Reducer
import com.cmbytes.compose.recipes.presentation.viewmodels.navigation.ScreenNavigationViewModel
import com.cmbytes.compose.recipes.presentation.viewmodels.navigation.ScreenNavigationViewModelImpl
import com.cmbytes.compose.recipe.presentation.store.RecipeAction
import com.cmbytes.compose.recipe.presentation.store.RecipeState
import com.cmbytes.compose.recipe.presentation.viewmodels.RecipeViewModel
import com.cmbytes.compose.recipe.presentation.viewmodels.RecipeViewModelImpl
import com.cmbytes.compose.recipe.presentation.viewmodels.navigation.SectionNavigationViewModel
import com.cmbytes.compose.recipe.presentation.viewmodels.navigation.SectionNavigationViewModelImpl
import com.cmbytes.compose.recipes.presentation.store.RecipesAction
import com.cmbytes.compose.recipes.presentation.store.RecipesState
import com.cmbytes.compose.recipes.presentation.viewmodels.RecipesViewModel
import com.cmbytes.compose.recipes.presentation.viewmodels.RecipesViewModelImpl
import com.cmbytes.compose.presentation.viewmodels.factory.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(includes = [RecipesDomainModule::class])
object RecipesPresentationModule {

    @Provides
    fun provideCoroutineDispatchers(): CoroutineDispatchers =
        CoroutineDispatchersProvider()

    @Provides
    fun provideSectionNavigationViewModel(
        activity: MainActivity,
        factory: ViewModelFactory
    ): SectionNavigationViewModel =
        ViewModelProvider(
            activity,
            factory
        ).get(SectionNavigationViewModelImpl::class.java)

    @Provides
    @IntoMap
    @ViewModelKey(SectionNavigationViewModelImpl::class)
    fun provideSectionNavigationViewModelImpl(): ViewModel = SectionNavigationViewModelImpl()

    @Provides
    fun provideScreenNavigationViewModel(
        activity: MainActivity,
        factory: ViewModelFactory
    ): ScreenNavigationViewModel =
        ViewModelProvider(
            activity,
            factory
        ).get(ScreenNavigationViewModelImpl::class.java)

    @Provides
    @IntoMap
    @ViewModelKey(ScreenNavigationViewModelImpl::class)
    fun provideScreenViewModelImpl(): ViewModel = ScreenNavigationViewModelImpl()

    @Provides
    fun provideRecipesViewModel(
        activity: MainActivity,
        factory: ViewModelFactory
    ): RecipesViewModel =
        ViewModelProvider(
            activity,
            factory
        ).get(RecipesViewModelImpl::class.java)

    @Provides
    @IntoMap
    @ViewModelKey(RecipesViewModelImpl::class)
    fun provideRecipesViewModelImpl(
        recipesReducer: Reducer<RecipesAction, RecipesState>,
        getRecipes: GetRecipes,
        coroutineDispatchers: CoroutineDispatchers
    ): ViewModel = RecipesViewModelImpl(recipesReducer, getRecipes, coroutineDispatchers)

    @Provides
    fun provideRecipeViewModel(
        activity: MainActivity,
        factory: ViewModelFactory
    ): RecipeViewModel =
        ViewModelProvider(
            activity,
            factory
        ).get(RecipeViewModelImpl::class.java)

    @Provides
    @IntoMap
    @ViewModelKey(RecipeViewModelImpl::class)
    fun provideRecipeViewModelImpl(
        recipesProxy: RecipesProxy,
        coroutineDispatchers: CoroutineDispatchers
    ): ViewModel = RecipeViewModelImpl(recipesProxy, coroutineDispatchers)

    @Provides
    fun provideRecipesProxy(
        recipesReducer: Reducer<RecipesAction, RecipesState>,
        recipeReducer: Reducer<RecipeAction, RecipeState>
    ): RecipesProxy = RecipesProxyImpl(recipesReducer, recipeReducer)
}