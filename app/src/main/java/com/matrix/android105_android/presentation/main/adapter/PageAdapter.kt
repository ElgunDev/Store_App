package com.matrix.android105_android.presentation.main.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.matrix.android105_android.presentation.product.ProductFragment
import com.matrix.android105_android.presentation.profil.ProfilFragment
import com.matrix.android105_android.presentation.wishList.WishListFragment

class PageAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->ProductFragment()
            1->WishListFragment()
            2->ProfilFragment()
            else->ProductFragment()
        }
    }

}