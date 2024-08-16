package com.matrix.android105_android.presentation.productDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

import com.matrix.android105_android.R

import com.matrix.android105_android.databinding.FragmentProductDetailBinding
import javax.inject.Inject


class ProductDetailFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailBinding
    @Inject
    private lateinit var viewModel: ProductDetailViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeProductDetail()
        viewModel.getProductDetail()
    }

    private fun observeProductDetail(){
        viewModel.products.observe(viewLifecycleOwner){
            it?.let {
                binding.txtBrend.text =it.title
                binding.txtId.text = it.id.toString()
                binding.txtCategory.text = it.category
                if (it.image.isNotEmpty()) {
                    Glide.with(binding.root.context)
                        .load(it.image)
                        .into(binding.imageView3)
                } else {
                    binding.imageView3.setImageResource(R.drawable.ic_launcher_background)
                }
            }
        }
    }
}