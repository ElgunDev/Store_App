package com.matrix.android105_android.data.repository.productDetail

import com.matrix.android105_android.data.mapper.toDomain
import com.matrix.android105_android.data.repository.productDetail.impl.ProductDetailRemoteRepository
import com.matrix.android105_android.domain.models.ProductModelDto
import com.matrix.android105_android.domain.repository.productDetail.IProductDetailRepository
import javax.inject.Inject

class ProductDetailImplRepository @Inject constructor(
    private val productDetailRemoteRepository: ProductDetailRemoteRepository,
            ):IProductDetailRepository{

    override suspend fun getProductById(productId: String): List<ProductModelDto> {
        var result = listOf<ProductModelDto>()
        val response  = productDetailRemoteRepository.getProductById(productId)
        if (response.isSuccessful){
            response.body()?.let {
               result= listOf(it.toDomain())
            }
        }
        return result
    }
}