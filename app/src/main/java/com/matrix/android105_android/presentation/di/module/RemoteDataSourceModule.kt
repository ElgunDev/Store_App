package com.matrix.android105_android.presentation.di.module

import com.matrix.android105_android.data.repository.product.IProductRemoteRepository
import com.matrix.android105_android.data.repository.product.ProductImplRepository
import com.matrix.android105_android.data.repository.product.impl.ProductRemoteRepository
import com.matrix.android105_android.data.repository.productDetail.IProductDetailRemoteRepository
import com.matrix.android105_android.data.repository.productDetail.impl.ProductDetailRemoteRepository
import com.matrix.android105_android.domain.repository.product.IProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@InstallIn(SingletonComponent::class)
@Module
abstract class RemoteDataSourceModule {
    @Binds
    @Singleton
    abstract   fun provideProductRemoteRepository(productRemoteRepository: ProductRemoteRepository): IProductRemoteRepository
    @Binds
    @Singleton
    abstract   fun provideProductDetailRemoteRepository(productDetailRemoteRepository: ProductDetailRemoteRepository): IProductDetailRemoteRepository
}