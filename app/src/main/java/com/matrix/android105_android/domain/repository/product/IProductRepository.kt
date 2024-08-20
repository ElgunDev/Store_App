package com.matrix.android105_android.domain.repository.product

import com.matrix.android105_android.domain.models.ProductModelDto
import com.matrix.android105_android.utils.NetworkResource

interface IProductRepository {
    suspend fun getProducts():NetworkResource<List<ProductModelDto>>
}