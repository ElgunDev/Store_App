package com.matrix.android105_android.data.repository.product

import com.matrix.android105_android.data.mapper.toDomain
import com.matrix.android105_android.domain.models.ProductModelDto
import com.matrix.android105_android.domain.repository.product.IProductRepository
import javax.inject.Inject

class ProductImplRepository @Inject constructor(
    private val productRemoteRepository:IProductRemoteRepository
):IProductRepository{
    override suspend fun getProducts(): List<ProductModelDto> {
        var result = listOf<ProductModelDto>()
        val response = productRemoteRepository.getProducts()
        if (response.isSuccessful){
            response.body()?.let {
                result = it.map {model->
                    model.toDomain()
                }
            }
        }
        return result
    }
}