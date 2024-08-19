package com.matrix.android105_android.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.matrix.android105_android.data.db.dao.WishProductDao
import com.matrix.android105_android.data.db.entity.WishProductEntity

@Database(entities = [WishProductEntity::class] , version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun WishProductDao():WishProductDao
}