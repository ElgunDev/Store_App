package com.matrix.android105_android.data.db.entity

import androidx.room.Entity

@Entity
data class WishProductEntity(
    val id:Int,
    val image:String,
    val productName:String,
    val price:Int
)