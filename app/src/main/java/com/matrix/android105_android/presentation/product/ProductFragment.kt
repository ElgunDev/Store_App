package com.matrix.android105_android.presentation.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager

import com.matrix.android105_android.R
import com.matrix.android105_android.databinding.FragmentProductBinding
import com.matrix.android105_android.presentation.MyApp
import com.matrix.android105_android.presentation.main.MainFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProductFragment : Fragment() {
    private lateinit var binding: FragmentProductBinding
    @Inject
    lateinit var productViewModel: ProductViewModel
    lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeProducts()
        CoroutineScope(Dispatchers.IO).launch {
            productViewModel.getProducts()
        }
    }

   private fun observeProducts(){
        productViewModel.products.observe(viewLifecycleOwner){
             adapter = ProductAdapter(it){
                 val action =MainFragmentDirections.actionMainFragmentToProductDetailFragment(it.id.toString())
                     findNavController().navigate(action)
             }
             binding.rcyProducts.adapter =adapter
            binding.rcyProducts.layoutManager = GridLayoutManager(requireContext() ,2)
        }
    }



}