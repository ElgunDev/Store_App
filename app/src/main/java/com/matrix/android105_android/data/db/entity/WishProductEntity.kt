package com.matrix.android105_android.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WishProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val image:String,
    val productName:String,
    val price:Int
)