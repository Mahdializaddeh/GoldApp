package info.alirezaahmadi.goldapp.remote.golds

import info.alirezaahmadi.goldapp.remote.dataModel.GoldModel

/**
 * Callback interface for handling responses from gold-related API requests.
 */
interface GoldRequest {

    /**
     * Callback method invoked when the gold-related API request is successful.
     * @param data The [GoldModel] object containing the retrieved gold data.
     */
    fun onSuccess(data: GoldModel)

    /**
     * Callback method invoked when the gold-related API request is not successful.
     * @param message A message indicating the reason for the unsuccessful request.
     */
    fun onNotSuccess(message: String)

    /**
     * Callback method invoked when an error occurs during the gold-related API request.
     * @param error A string containing details about the error.
     */
    fun onError(error: String)
}
