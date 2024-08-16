package com.matrix.android105_android.presentation.di.component

import com.matrix.android105_android.presentation.di.module.NetworkModule
import com.matrix.android105_android.presentation.di.module.RemoteDataSourceModule
import com.matrix.android105_android.presentation.di.module.RepositoryModule
import com.matrix.android105_android.presentation.product.ProductFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        RemoteDataSourceModule::class
    ]
)
abstract class AppComponent {
    abstract fun inject(productFragment: ProductFragment)

}