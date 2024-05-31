package info.alirezaahmadi.goldapp.remote.dataModel

/**
 * Represents a GoldModel object containing message and data.
 * @property message The message associated with the gold data.
 * @property data The data containing golds and currencies.
 */
data class GoldModel(
    val message: String,
    val data: AllData
)

/**
 * Represents the AllData object containing golds and currencies.
 * @property golds The list of golds.
 * @property currencies The list of currencies.
 */
data class AllData(
    val golds: List<ContentModel>,
    val currencies: List<ContentModel>
)

/**
 * Represents a ContentModel object containing label and price.
 * @property label The label associated with the content.
 * @property price The price associated with the content.
 */
data class ContentModel(
    val label: String,
    val price: Int
)
