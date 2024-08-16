package com.matrix.android105_android.data.mapper

import com.matrix.android105_android.data.api.model.ProductApiModel
import com.matrix.android105_android.domain.models.ProductModelDto

fun ProductApiModel.toDomain(): ProductModelDto {
    return ProductModelDto(
        category,
        description,
        id,
        image,
        price,
        title
    )
}