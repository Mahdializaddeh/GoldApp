package info.alirezaahmadi.goldapp.remote.time

import info.alirezaahmadi.goldapp.remote.dataModel.DateModel

interface TimeRequest {

    fun onSuccess(data: DateModel)

    fun onNotSuccess(message: String)

    fun onError(error: String)

}