package info.alirezaahmadi.goldapp.remote.dataModel

import com.google.gson.annotations.SerializedName

/**
 * Represents a DateModel object containing success status, message, help, and date information.
 * @property success The success status of the date request.
 * @property message The message associated with the date request.
 * @property help The help information related to the date request.
 * @property date The Date object containing specific date values.
 */
data class DateModel(
    val success: Int,
    val message: String,
    val help: String,
    val date: Date
)

/**
 * Represents a Date object containing date values.
 * @property F_value The value associated with the "F" key.
 * @property Y_value The value associated with the "Y" key.
 * @property j_value The value associated with the "j" key.
 * @property l_value The value associated with the "l" key.
 */
data class Date(
    @SerializedName("F") val F_value: String,
    @SerializedName("Y") val Y_value: String,
    @SerializedName("j") val j_value: String,
    @SerializedName("l") val l_value: String
)
