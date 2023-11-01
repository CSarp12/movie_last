package Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkService private constructor() {
    private val mRetrofit: Retrofit

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        private var mInstance: NetworkService? = null
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
        val instance: NetworkService?
            get() {
                if (mInstance == null) {
                    mInstance = NetworkService()
                }
                return mInstance
            }
    }
}