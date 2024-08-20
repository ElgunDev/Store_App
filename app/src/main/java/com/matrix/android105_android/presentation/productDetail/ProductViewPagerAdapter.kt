package com.matrix.android105_android.presentation.productDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matrix.android105_android.databinding.ItemProductDetailBinding

class ProductViewPagerAdapter:RecyclerView.Adapter<ProductViewPagerAdapter.ProductViewPagerViewHolder>(){
    private val diffCallBack = object :DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
           return oldItem==newItem
        }

    }

    private val diffUtil = AsyncListDiffer(this,diffCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewPagerViewHolder {
        val binding = ItemProductDetailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewPagerViewHolder((binding))
    }

    override fun getItemCount(): Int {
      return  diffUtil.currentList.size
    }

    override fun onBindViewHolder(holder: ProductViewPagerViewHolder, position: Int) {
        holder.bind(diffUtil.currentList[position])
    }

    inner class ProductViewPagerViewHolder(private val binding:ItemProductDetailBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(images:String){
            Glide.with(binding.root.context)
                .load(images)
                .into(binding.imgproduct)
        }

    }
    fun submitList(list: List<String>?){
        diffUtil.submitList(list)
    }
}