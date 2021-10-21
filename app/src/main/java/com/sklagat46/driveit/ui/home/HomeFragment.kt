package com.sklagat46.driveit.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sklagat46.driveit.databinding.FragmentHomeBinding
import com.sklagat46.driveit.ui.cars.AvailableCarsActivity
import com.sklagat46.driveit.ui.home.model.Cars
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private var topDealsAdapter: TopDealsAdapter? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.ivAvailableCar.setOnClickListener {
            availableCars()
        }

        setUpAdapter()

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it

        })
        return root
    }

    private fun setUpAdapter() {
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvTopDeals.layoutManager = layoutManager

        topDealsAdapter = TopDealsAdapter(requireContext(),carList())
        binding.rvTopDeals.adapter = topDealsAdapter
    }

    private fun availableCars() {
        val carsIntent =
            Intent(requireContext(), AvailableCarsActivity::class.java)
        requireContext().startActivity(carsIntent)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun carList(): List<Cars> {
        val cars = ArrayList<Cars>()

        val car = Cars()
        car.apply {
             id = "3"
             type = "Mustang"
             model = "AMG 340"
             dealType = "Daily"
             imageUrl = "https://images.unsplash.com/photo-1494976388531-d1058494cdd8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
        }


        val car1 = Cars()
        car1.apply {
             id = "3"
             type = "Mustang"
             model = "AMG 340"
             dealType = "Daily"
             imageUrl = "https://images.unsplash.com/photo-1494976388531-d1058494cdd8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
        }

        val car2 = Cars()
        car2.apply {
             id = "3"
             type = "Mustang"
             model = "AMG 340"
             dealType = "Daily"
             imageUrl = "https://images.unsplash.com/photo-1494976388531-d1058494cdd8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
        }

        val car3 = Cars()
        car3.apply {
             id = "3"
             type = "Mustang"
             model = "AMG 340"
             dealType = "Daily"
             imageUrl = "https://images.unsplash.com/photo-1494976388531-d1058494cdd8?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
        }

        val car9 = Cars()
        car9.apply {
            id = "3"
            type = "Asphalt"
            model = "AMG 340"
            dealType = "Daily"
            imageUrl = "https://images.unsplash.com/photo-1568605117036-5fe5e7bab0b7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
        }

        val car10 = Cars()
        car10.apply {
            id = "3"
            type = "black sedan"
            model = "AMG 340"
            dealType = "weekly"
            imageUrl = "https://images.unsplash.com/photo-1607892378625-68c08a8e038d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDd8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60"
        }

        val car11 = Cars()
        car11.apply {
            id = "3"
            type = "porche"
            model = "AMG 340"
            dealType = "monthly"
            imageUrl = "https://images.unsplash.com/photo-1503376780353-7e6692767b70?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDh8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60"
        }

        cars.add(car)
        cars.add(car1)
        cars.add(car2)
        cars.add(car3)
        cars.add(car9)
        cars.add(car11)
        cars.add(car10)

        return cars
    }
}