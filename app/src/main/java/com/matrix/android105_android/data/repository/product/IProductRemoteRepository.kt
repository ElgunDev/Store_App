package com.matrix.android105_android.data.repository.product

import com.matrix.android105_android.data.api.model.Product
import com.matrix.android105_android.data.api.model.Products
import retrofit2.Response

interface IProductRemoteRepository {

   suspend fun getProducts():Response<Products>
}