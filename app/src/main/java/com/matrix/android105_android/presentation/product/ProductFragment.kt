package com.matrix.android105_android.presentation.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.util.query

import com.matrix.android105_android.R
import com.matrix.android105_android.databinding.FragmentProductBinding
import com.matrix.android105_android.presentation.MyApp
import com.matrix.android105_android.presentation.main.MainFragmentDirections
import com.matrix.android105_android.utils.NetworkResource
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
        searchProduct()
    }

   private fun observeProducts(){
        productViewModel.products.observe(viewLifecycleOwner){
            when(it){
                is NetworkResource.Success->{
                    adapter = ProductAdapter(it.data){

                        val action =MainFragmentDirections.actionMainFragmentToProductDetailFragment( it.id.toString())
                        findNavController().navigate(action)
                    }
                    binding.rcyProducts.adapter =adapter
                    binding.rcyProducts.layoutManager = GridLayoutManager(requireContext() ,2)
                    binding.progressBar.visibility = View.INVISIBLE
                }
                is NetworkResource.Loading->{
                    binding.progressBar.visibility = View.VISIBLE
                }
                is NetworkResource.Error-> {
                    Toast.makeText(requireContext(), "Xeta bas verdi", Toast.LENGTH_SHORT).show()
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun searchProduct(){
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
              return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    filterProduct(newText)
                }
                return true
            }

        })
    }

    private fun filterProduct(query:String){
        val currentProducts = when (val productResource = productViewModel.products.value) {
            is NetworkResource.Success -> productResource.data
            else -> null
        }

        if (!query.isNullOrEmpty() && currentProducts != null) {
            val filteredList = currentProducts.filter { product ->
                product.title.contains(query, ignoreCase = true)
            }
            adapter.submitList(filteredList)
        } else {
         adapter.submitList(currentProducts!!)
        }
    }



}