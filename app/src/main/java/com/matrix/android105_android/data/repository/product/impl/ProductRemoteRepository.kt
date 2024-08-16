package com.matrix.android105_android.data.repository.product.impl

import com.matrix.android105_android.data.api.model.ProductApiModel
import com.matrix.android105_android.data.api.services.ProductService
import com.matrix.android105_android.data.repository.product.IProductRemoteRepository
import retrofit2.Response
import javax.inject.Inject

class ProductRemoteRepository @Inject constructor(private val productService: ProductService):IProductRemoteRepository {
    override suspend fun getProducts(): Response<List<ProductApiModel>> {
        return productService.getProducts()
    }
}