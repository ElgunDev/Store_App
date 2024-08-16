package com.matrix.android105_android.domain.repository.product

import com.matrix.android105_android.domain.models.ProductModelDto

interface IProductRepository {
    suspend fun getProducts():List<ProductModelDto>
}