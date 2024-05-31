package info.alirezaahmadi.goldapp.remote.golds

import info.alirezaahmadi.goldapp.remote.dataModel.GoldModel
import retrofit2.Call
import retrofit2.http.GET

/**
 * Retrofit service interface for gold-related API endpoints.
 */
interface GoldsApiService {

    /**
     * Makes a GET request to retrieve gold data.
     * @return A [Call] object representing the asynchronous request to retrieve gold data.
     */
    @GET("currencies")
    fun getGolds(): Call<GoldModel>
}
