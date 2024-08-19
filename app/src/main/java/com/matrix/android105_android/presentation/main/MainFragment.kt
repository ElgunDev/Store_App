package com.matrix.android105_android.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

import com.matrix.android105_android.R
import com.matrix.android105_android.databinding.FragmentMainBinding
import com.matrix.android105_android.presentation.main.adapter.PageAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
   lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewPager()
        setUpBottomNav()
    }

    fun setUpViewPager(){
        val adapter = PageAdapter(requireActivity().supportFragmentManager,lifecycle)
        binding.viewPager.adapter = adapter
    }

    fun setUpBottomNav(){
        binding.bottomNavMenu.setOnNavigationItemSelectedListener {
            binding.viewPager.currentItem = when(it.itemId){
                R.id.Product ->0
                R.id.WishList ->1
                R.id.Profil ->2
                else->0
            }
            true
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNavMenu.selectedItemId = when(position){
                    0->R.id.Product
                    1->R.id.WishList
                    2->R.id.Profil
                    else->R.id.Product
                }

            }
        })
    }

}