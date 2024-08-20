package com.matrix.android105_android.domain.repository.productDetail

import com.matrix.android105_android.domain.models.ProductModelDto



interface IProductDetailRepository {

    suspend fun getProductById(productId:String):ProductModelDto
}