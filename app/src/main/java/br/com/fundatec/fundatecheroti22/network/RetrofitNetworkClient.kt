package br.com.fundatec.fundatecheroti22.network

import br.com.fundatec.fundatecheroti22.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 60L

object RetrofitNetworkClient {

    fun createNetworkClient(baseUrl: String) =
        retrofitClient(
            baseUrl,
            httpClint(),
            moshi()
        )

    private fun moshi() = MoshiConverterFactory.create(
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    )

    private fun httpClint(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(logginInterceptor())
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .build()

    private fun logginInterceptor() =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    private fun retrofitClient(
        baseUrl: String,
        htttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(htttpClient)
        .addConverterFactory(moshiConverterFactory)
        .build()

}