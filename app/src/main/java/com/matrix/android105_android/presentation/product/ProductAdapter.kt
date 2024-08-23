package com.matrix.android105_android.presentation.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matrix.android105_android.R
import com.matrix.android105_android.databinding.ItemProductsBinding
import com.matrix.android105_android.domain.models.ProductModelDto

class ProductAdapter(
    private var productList: List<ProductModelDto>,
    private val onItemClicked: (ProductModelDto) ->Unit
    ):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
       val binding = ItemProductsBinding.inflate(LayoutInflater.from(parent.context) , parent,false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        return holder.bind(productList[position])
    }

    inner class ProductViewHolder(private val binding: ItemProductsBinding):RecyclerView.ViewHolder(binding.root){
             fun bind(productModelDto: ProductModelDto) {
                     binding.txtProductName.text = productModelDto.title
                     binding.txtId.text = productModelDto.id.toString()
                     binding.txtPrice.text = productModelDto.price.toString()
                     if (productModelDto.images.isNotEmpty()) {
                         Glide.with(binding.root.context)
                             .load(productModelDto.images[0])
                             .into(binding.imageView)
                     } else {
                         binding.imageView.setImageResource(R.drawable.ic_launcher_background)
                     }
                     itemView.setOnClickListener {
                         onItemClicked(productModelDto)
                     }

             }
    }
    fun submitList(updatedList: List<ProductModelDto>) {
        productList = updatedList
        notifyDataSetChanged()
    }

}