package com.matrix.android105_android.presentation.di.module

import android.content.Context
import androidx.room.Room
import com.matrix.android105_android.data.db.AppDatabase
import com.matrix.android105_android.data.db.dao.WishProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context):AppDatabase{
       return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "LikeProduct"
        ).build()
    }

    @Provides
    @Singleton
    fun provideWishProductDao(appDatabase: AppDatabase):WishProductDao{
        return appDatabase.WishProductDao()
    }
}