package com.matrix.android105_android.presentation.di.module

import com.matrix.android105_android.data.repository.product.ProductImplRepository
import com.matrix.android105_android.data.repository.productDetail.ProductDetailImplRepository
import com.matrix.android105_android.domain.repository.product.IProductRepository
import com.matrix.android105_android.domain.repository.productDetail.IProductDetailRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
  abstract   fun provideProductRepository(productImplRepository: ProductImplRepository):IProductRepository

  @Binds
  @Singleton
    abstract   fun provideProductDetailRepository(productDetailImplRepository: ProductDetailImplRepository): IProductDetailRepository

}