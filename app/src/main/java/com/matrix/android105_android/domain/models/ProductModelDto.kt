package com.matrix.android105_android.domain.models

import com.matrix.android105_android.data.api.model.Product

data class ProductModelDto(
    val category: String,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Double,
    val title: String,

)