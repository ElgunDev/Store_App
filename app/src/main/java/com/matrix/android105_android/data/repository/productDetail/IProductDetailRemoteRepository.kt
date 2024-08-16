package com.matrix.android105_android.data.repository.productDetail

import com.matrix.android105_android.data.api.model.ProductApiModel
import retrofit2.Response

interface IProductDetailRemoteRepository {

    suspend fun getProductById(productId:String): Response<ProductApiModel>
}