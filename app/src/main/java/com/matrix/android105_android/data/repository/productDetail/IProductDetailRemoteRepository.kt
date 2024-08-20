package com.matrix.android105_android.data.repository.productDetail

import com.matrix.android105_android.data.api.model.Product
import com.matrix.android105_android.data.api.model.Products
import retrofit2.Response

interface IProductDetailRemoteRepository {

    suspend fun getProductById(productId:String): Response<Product>
}