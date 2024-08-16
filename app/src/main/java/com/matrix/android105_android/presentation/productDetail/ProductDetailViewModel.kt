package com.matrix.android105_android.presentation.productDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matrix.android105_android.domain.models.ProductModelDto
import com.matrix.android105_android.domain.usecase.GetProductByIdUseCase
import com.matrix.android105_android.domain.usecase.GetProductUseCase
import javax.inject.Inject

class ProductDetailViewModel @Inject constructor(
    private val getProductByIdUseCase: GetProductByIdUseCase
            ):ViewModel() {
    private val _products = MutableLiveData<ProductModelDto>()
    val products: LiveData<ProductModelDto>
        get() = _products

    suspend fun getProductDetail(productId:String){
        val products = getProductByIdUseCase.execute(productId)
        _products.value = products.firstOrNull()
    }
}