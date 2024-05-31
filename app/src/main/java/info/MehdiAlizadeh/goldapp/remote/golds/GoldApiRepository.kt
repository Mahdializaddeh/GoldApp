package info.alirezaahmadi.goldapp.remote.golds

import info.alirezaahmadi.goldapp.remote.MainRetrofitService
import info.alirezaahmadi.goldapp.remote.dataModel.GoldModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Repository class responsible for handling gold-related API requests.
 */
class GoldApiRepository private constructor() {

    companion object {

        private var apiRepository: GoldApiRepository? = null

        /**
         * Provides a singleton instance of [GoldApiRepository].
         */
        val instance: GoldApiRepository
            get() {
                if (apiRepository == null) apiRepository = GoldApiRepository()
                return apiRepository!!
            }

    }

    /**
     * Makes a network request to fetch gold data.
     * @param request The GoldRequest object containing request parameters.
     */
    fun getGolds(
        request: GoldRequest
    ) {

        MainRetrofitService.goldApiService.getGolds().enqueue(

            object : Callback<GoldModel> {

                override fun onResponse(call: Call<GoldModel>, response: Response<GoldModel>) {

                    if (response.isSuccessful) {
                        val data = response.body() as GoldModel
                        request.onSuccess(data)
                    } else
                        request.onNotSuccess("Not Success")

                }

                override fun onFailure(call: Call<GoldModel>, t: Throwable) {
                    request.onError("Error : ${t.message}")
                }

            }

        )

    }

}
