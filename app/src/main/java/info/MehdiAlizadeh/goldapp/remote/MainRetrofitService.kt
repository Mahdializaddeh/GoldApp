package info.alirezaahmadi.goldapp.remote

import info.alirezaahmadi.goldapp.remote.golds.GoldsApiService
import info.alirezaahmadi.goldapp.remote.time.TimeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Singleton object responsible for providing Retrofit service instances for making network requests.
 */
object MainRetrofitService {

    // Base URL for the API endpoints
    private const val url = "https://tools.daneshjooyar.com/api/v1/"

    // Retrofit instance configured with Gson converter factory
    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Retrofit service instance for time-related API endpoints
    val apiService: TimeApiService = retrofit.create(TimeApiService::class.java)

    // Retrofit service instance for gold-related API endpoints
    val goldApiService: GoldsApiService = retrofit.create(GoldsApiService::class.java)

}
