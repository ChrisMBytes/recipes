package com.cmbytes.compose.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.cmbytes.compose.MainActivity
import com.cmbytes.compose.coroutines.CoroutineDispatchers
import com.cmbytes.compose.coroutines.CoroutineDispatchersProvider
import com.cmbytes.compose.domain.usecases.GetRecipes
import com.cmbytes.compose.presentation.proxy.RecipesProxy
import com.cmbytes.compose.presentation.proxy.RecipesProxyImpl
import com.cmbytes.compose.presentation.store.Reducer
import com.cmbytes.compose.presentation.viewmodels.ScreenNavigationViewModel
import com.cmbytes.compose.presentation.viewmodels.ScreenNavigationViewModelImpl
import com.cmbytes.compose.recipe.presentation.store.RecipeAction
import com.cmbytes.compose.recipe.presentation.store.RecipeState
import com.cmbytes.compose.recipe.presentation.viewmodels.RecipeViewModel
import com.cmbytes.compose.recipe.presentation.viewmodels.RecipeViewModelImpl
import com.cmbytes.compose.recipe.presentation.viewmodels.SectionNavigationViewModel
import com.cmbytes.compose.recipe.presentation.viewmodels.SectionNavigationViewModelImpl
import com.cmbytes.compose.recipes.presentation.store.RecipesAction
import com.cmbytes.compose.recipes.presentation.store.RecipesState
import com.cmbytes.compose.recipes.presentation.viewmodels.RecipesViewModel
import com.cmbytes.compose.recipes.presentation.viewmodels.RecipesViewModelImpl
import com.cmbytes.compose.viewmodel.factory.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(
    includes = [
        AppBindingModule::class,
        RecipesNetworkModule::class,
        RecipesDomainModule::class
    ]
)
object AppModule {

    @Provides
    fun provideCoroutineDispatchers(): CoroutineDispatchers =
        CoroutineDispatchersProvider()

    @Provides
    fun provideSectionNavigationViewModel(
        activity: MainActivity,
        factory: ViewModelFactory
    ): SectionNavigationViewModel =
        ViewModelProviders.of(
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
        ViewModelProviders.of(
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
        ViewModelProviders.of(
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
        ViewModelProviders.of(
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