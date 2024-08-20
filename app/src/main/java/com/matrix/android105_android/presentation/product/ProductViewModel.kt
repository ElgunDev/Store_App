package com.matrix.android105_android.presentation.product


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matrix.android105_android.domain.models.ProductModelDto

import com.matrix.android105_android.domain.usecase.GetProductUseCase
import com.matrix.android105_android.utils.NetworkResource
import javax.inject.Inject

class ProductViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase
):ViewModel(){
    private val _products =MutableLiveData<NetworkResource<List<ProductModelDto>>>()
    val products: LiveData<NetworkResource<List<ProductModelDto>>>
        get()=_products

    suspend fun getProducts(){
        val product = getProductUseCase.execute()
        _products.postValue(product)
    }

}