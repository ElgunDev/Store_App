package com.matrix.android105_android.domain.usecase

import com.matrix.android105_android.domain.models.ProductModelDto
import com.matrix.android105_android.domain.repository.product.IProductRepository
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val productRepository:IProductRepository
) {
    suspend fun execute():List<ProductModelDto>{
        return productRepository.getProducts()
    }
}