package com.simx.moviecatalog.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.simx.moviecatalog.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiCore {

    fun retrofitConfig(url:String?):Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client())
            .build()
    }

    /**
     * Config GSON
     * @return
     */
    private val gson: Gson
        get() {
            val gsonBuilder = GsonBuilder()
                .serializeNulls()
                .setLenient()
                .setPrettyPrinting()
            return gsonBuilder.create()
        }
    /**
     * Config OkhttpClient and interceptions
     * @return
     */
    private fun client(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(levelInterceptor())
            .build()
    }
    private fun levelInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        return if (BuildConfig.DEBUG){
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        }else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE)
        }
    }

}