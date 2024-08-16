package com.matrix.android105_android.data.api.services

import com.matrix.android105_android.data.api.model.ProductApiModel

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    suspend fun getProducts():Response<List<ProductApiModel>>

    @GET("auth/products/{id}")
    suspend fun getProductById(@Path("id") id:Int):Response<ProductApiModel>
}