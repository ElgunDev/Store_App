package com.matrix.android105_android.data.api.services

import com.matrix.android105_android.data.api.model.Product
import com.matrix.android105_android.data.api.model.Products
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    suspend fun getProducts():Response<Products>

    @GET("products/{id}")
    suspend fun getProductById(@Path("id") id:Int):Response<Product>
}