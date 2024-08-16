package com.matrix.android105_android.domain.usecase

import com.matrix.android105_android.domain.models.ProductModelDto
import com.matrix.android105_android.domain.repository.productDetail.IProductDetailRepository
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(
    private val productDetailRepository: IProductDetailRepository
) {
    suspend fun execute(productId:String):List<ProductModelDto>{
        return productDetailRepository.getProductById(productId)
    }
}