package com.matrix.android105_android.presentation.productDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide

import com.matrix.android105_android.R

import com.matrix.android105_android.databinding.FragmentProductDetailBinding
import com.matrix.android105_android.presentation.MyApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProductDetailFragment : Fragment() {
     lateinit var binding: FragmentProductDetailBinding
     lateinit var adapter:ProductViewPagerAdapter
    @Inject
     lateinit var viewModel: ProductDetailViewModel
     private val myArgument:ProductDetailFragmentArgs by navArgs()


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
        val productId = myArgument.id
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.getProductDetail(productId)
        }
        getBack()
    }

    private fun observeProductDetail(){
        viewModel.products.observe(viewLifecycleOwner){
            it?.let {
                    val imageList = it.images
                    adapter = ProductViewPagerAdapter()
                    binding.viewPager.adapter = adapter
                    adapter.submitList(imageList)
                    binding.txtBrend.text = it.title
                    binding.txtId.text = it.id.toString()
                    binding.txtCategory.text = it.category
                    binding.dots.attachTo(binding.viewPager)
            }
        }

    }

    private fun getBack(){
        binding.btnBack.setOnClickListener{
            findNavController().popBackStack()
        }
    }
}