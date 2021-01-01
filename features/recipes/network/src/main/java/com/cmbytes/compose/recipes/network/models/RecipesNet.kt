package com.cmbytes.compose.recipes.network.models

import com.squareup.moshi.Json

data class RecipesNet(
    @field:Json(name = "recipes") val recipes: List<RecipeNet>
)

data class RecipeNet(
    @field:Json(name = "aggregateLikes") val aggregateLikes: Int,
    @field:Json(name = "analyzedInstructions") val analyzedInstructions: List<AnalyzedInstructionNet>,
    @field:Json(name = "author") val author: String?,
    @field:Json(name = "cheap") val cheap: Boolean,
    @field:Json(name = "creditsText") val creditsText: String?,
    @field:Json(name = "cuisines") val cuisines: List<String>,
    @field:Json(name = "dairyFree") val dairyFree: Boolean,
    @field:Json(name = "diets") val diets: List<String>,
    @field:Json(name = "dishTypes") val dishTypes: List<String>,
    @field:Json(name = "extendedIngredients") val extendedIngredients: List<ExtendedIngredientNet>,
    @field:Json(name = "gaps") val gaps: String,
    @field:Json(name = "glutenFree") val glutenFree: Boolean,
    @field:Json(name = "healthScore") val healthScore: Double,
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "image") val image: String?,
    @field:Json(name = "imageType") val imageType: String?,
    @field:Json(name = "instructions") val instructions: String,
    @field:Json(name = "license") val license: String?,
    @field:Json(name = "lowFodmap") val lowFodmap: Boolean,
    @field:Json(name = "occasions") val occasions: List<String>,
    @field:Json(name = "originalId") val originalId: Any?,
    @field:Json(name = "pricePerServing") val pricePerServing: Double,
    @field:Json(name = "readyInMinutes") val readyInMinutes: Int,
    @field:Json(name = "servings") val servings: Int,
    @field:Json(name = "sourceName") val sourceName: String?,
    @field:Json(name = "sourceUrl") val sourceUrl: String,
    @field:Json(name = "spoonacularScore") val spoonacularScore: Double,
    @field:Json(name = "spoonacularSourceUrl") val spoonacularSourceUrl: String,
    @field:Json(name = "summary") val summary: String,
    @field:Json(name = "sustainable") val sustainable: Boolean,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "vegan") val vegan: Boolean,
    @field:Json(name = "vegetarian") val vegetarian: Boolean,
    @field:Json(name = "veryHealthy") val veryHealthy: Boolean,
    @field:Json(name = "veryPopular") val veryPopular: Boolean,
    @field:Json(name = "weightWatcherSmartPoints") val weightWatcherSmartPoints: Int
)

data class AnalyzedInstructionNet(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "steps") val steps: List<StepNet>
)

data class ExtendedIngredientNet(
    @field:Json(name = "aisle") val aisle: String?,
    @field:Json(name = "amount") val amount: Double,
    @field:Json(name = "consistency") val consistency: String?,
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "image") val image: String?,
    @field:Json(name = "measures") val measures: MeasuresNet,
    @field:Json(name = "meta") val meta: List<String>,
    @field:Json(name = "metaInformation") val metaInformation: List<String>,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "original") val original: String,
    @field:Json(name = "originalName") val originalName: String,
    @field:Json(name = "originalString") val originalString: String,
    @field:Json(name = "unit") val unit: String
)

data class StepNet(
    @field:Json(name = "equipment") val equipment: List<EquipmentNet>,
    @field:Json(name = "ingredients") val ingredients: List<IngredientNet>,
    @field:Json(name = "length") val length: LengthNet?,
    @field:Json(name = "number") val number: Int,
    @field:Json(name = "step") val step: String
)

data class EquipmentNet(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "image") val image: String?,
    @field:Json(name = "localizedName") val localizedName: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "temperature") val temperature: TemperatureNet?
)

data class IngredientNet(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "image") val image: String?,
    @field:Json(name = "localizedName") val localizedName: String,
    @field:Json(name = "name") val name: String
)

data class LengthNet(
    @field:Json(name = "number") val number: Int,
    @field:Json(name = "unit") val unit: String
)

data class TemperatureNet(
    @field:Json(name = "number") val number: Double,
    @field:Json(name = "unit") val unit: String
)

data class MeasuresNet(
    @field:Json(name = "metric") val metric: MetricNet,
    @field:Json(name = "us") val us: UsNet
)

data class MetricNet(
    @field:Json(name = "amount") val amount: Double,
    @field:Json(name = "unitLong") val unitLong: String,
    @field:Json(name = "unitShort") val unitShort: String
)

data class UsNet(
    @field:Json(name = "amount") val amount: Double,
    @field:Json(name = "unitLong") val unitLong: String,
    @field:Json(name = "unitShort") val unitShort: String
)


