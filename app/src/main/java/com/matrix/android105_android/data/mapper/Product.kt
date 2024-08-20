package com.matrix.android105_android.data.mapper

import com.matrix.android105_android.data.api.model.Product
import com.matrix.android105_android.data.api.model.Products
import com.matrix.android105_android.domain.models.ProductModelDto

fun Product.toDomain(): ProductModelDto {
    return ProductModelDto(
       category,
        description,
        id,
        images,
        price,
        title
    )
}