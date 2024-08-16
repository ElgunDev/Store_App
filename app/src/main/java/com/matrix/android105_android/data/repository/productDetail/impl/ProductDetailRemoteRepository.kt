package com.matrix.android105_android.data.repository.productDetail.impl

import com.matrix.android105_android.data.api.model.ProductApiModel
import com.matrix.android105_android.data.api.services.ProductService
import com.matrix.android105_android.data.repository.productDetail.IProductDetailRemoteRepository

import retrofit2.Response
import javax.inject.Inject

class ProductDetailRemoteRepository @Inject constructor(
    private val productService: ProductService):IProductDetailRemoteRepository {
    override suspend fun getProductById(productId:String): Response<ProductApiModel> {
      return productService.getProductById(productId.toInt())
    }


}