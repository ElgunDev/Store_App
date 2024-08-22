package com.matrix.android105_android.data.repository.product

import com.matrix.android105_android.data.mapper.toDomain
import com.matrix.android105_android.domain.models.ProductModelDto
import com.matrix.android105_android.domain.repository.product.IProductRepository
import com.matrix.android105_android.utils.NetworkResource
import java.lang.Exception
import javax.inject.Inject

class ProductImplRepository @Inject constructor(
    private val productRemoteRepository:IProductRemoteRepository
):IProductRepository{
    override suspend fun getProducts(): NetworkResource<List<ProductModelDto>> {
        try {
            val response = productRemoteRepository.getProducts()
            if (response.isSuccessful) {
                response.body()?.let {
                    val result = it.products.map {
                        it.toDomain()
                    }
                    return NetworkResource.Success(result)
                }
            }
            return NetworkResource.Error(response.message())
        }
        catch (ex:Exception){
            return NetworkResource.Error(ex.message.toString())
        }
    }
    }
