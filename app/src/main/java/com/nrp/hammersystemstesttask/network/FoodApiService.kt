package com.nrp.hammersystemstesttask.network

import com.nrp.hammersystemstesttask.model.Pizza
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://ig-food-menus.herokuapp.com/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FoodApiService {
    @GET("pizzas")
    suspend fun getPhotos():  List<Pizza>
}

object FoodApi {
    val retrofitService : FoodApiService by lazy {
        retrofit.create(FoodApiService::class.java)
    }
}