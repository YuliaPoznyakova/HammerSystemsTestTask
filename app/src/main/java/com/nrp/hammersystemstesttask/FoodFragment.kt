package com.nrp.hammersystemstesttask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.nrp.hammersystemstesttask.adapter.BannersAdapter
import com.nrp.hammersystemstesttask.adapter.CategoryAdapter
import com.nrp.hammersystemstesttask.adapter.FoodItemAdapter
import com.nrp.hammersystemstesttask.data.Bannersource
import com.nrp.hammersystemstesttask.data.Datasource
import com.nrp.hammersystemstesttask.databinding.FragmentFoodBinding

class FoodFragment : Fragment() {

    private val sharedViewModel: FoodViewModel by activityViewModels()
    private lateinit var binding: FragmentFoodBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = FragmentFoodBinding.inflate(inflater, container, false)
        val dataset = Datasource().loadCategories()
        val banners = Bannersource().loadBanners()

        binding = fragmentBinding

        binding.lifecycleOwner = this

        binding.viewModel = sharedViewModel

        binding.linearRecyclerView.adapter = FoodItemAdapter()
        binding.categoryRecyclerView.adapter = CategoryAdapter(requireContext(), dataset)
        binding.bannersRecyclerView.adapter = BannersAdapter(requireContext(), banners)
        return fragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.foodFragment = this
    }
}