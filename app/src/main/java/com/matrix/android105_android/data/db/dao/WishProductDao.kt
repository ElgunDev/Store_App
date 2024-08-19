package com.matrix.android105_android.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.matrix.android105_android.data.db.entity.WishProductEntity

@Dao
interface WishProductDao {

    @Insert
    suspend fun insert(wishProductEntity: WishProductEntity)

    @Query("DELETE FROM wishproductentity WHERE id=:productId")
    suspend fun deleteProductById(productId:Int)

    @Query("SELECT * FROM WishProductEntity")
    suspend fun getAll():List<WishProductEntity>

    @Query("SELECT * FROM wishproductentity WHERE id=:productId LIMIT 1")
    suspend fun getProductById(productId: Int):WishProductEntity?


}