package com.sklagat46.driveit.ui.cars

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.sklagat46.driveit.R
import com.sklagat46.driveit.ui.home.TopDealsAdapter
import com.sklagat46.driveit.ui.home.model.Cars
import com.sklagat46.driveit.utils.CustomGridLayoutManager
import com.sklagat46.driveit.utils.ItemOffsetDecoration
import kotlinx.android.synthetic.main.activity_available_cars.*

class AvailableCarsActivity : AppCompatActivity() {

    private var availableCarAdapter: AvailableCarsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_available_cars)


        setUpAdapter()

    }

    private fun setUpAdapter() {

        val layoutManager = CustomGridLayoutManager(this, 3)
        layoutManager.setScrollEnabled(true)
        rv_available_cars.layoutManager = layoutManager
        val itemDecoration = ItemOffsetDecoration(this, R.dimen.item_offset)
        rv_available_cars.addItemDecoration(itemDecoration)

        availableCarAdapter = AvailableCarsAdapter(this,carAvailableList())
        rv_available_cars.adapter = availableCarAdapter



    }



    private fun carAvailableList(): List<Cars> {
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
            type = "Asphalt"
            model = "AMG 340"
            dealType = "Daily"
            imageUrl = "https://images.unsplash.com/photo-1568605117036-5fe5e7bab0b7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
        }

        val car2 = Cars()
        car2.apply {
            id = "3"
            type = "Asphalt"
            model = "AMG 340"
            dealType = "Daily"
            imageUrl = "https://images.unsplash.com/photo-1568605117036-5fe5e7bab0b7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
        }

        val car3 = Cars()
        car3.apply {
            id = "3"
            type = "Asphalt"
            model = "AMG 340"
            dealType = "Daily"
            imageUrl = "https://images.unsplash.com/photo-1568605117036-5fe5e7bab0b7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
        }

        val car4 = Cars()
        car4.apply {
            id = "3"
            type = "beetle"
            model = "AMG 340"
            dealType = "Daily"
            imageUrl = "https://images.unsplash.com/photo-1568605117036-5fe5e7bab0b7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
        }

        val car6 = Cars()
        car6.apply {
            id = "3"
            type = "Asphalt"
            model = "AMG 340"
            dealType = "Daily"
            imageUrl = "https://images.unsplash.com/photo-1568605117036-5fe5e7bab0b7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
        }

        val car7 = Cars()
        car7.apply {
            id = "3"
            type = "Mustang"
            model = "AMG 340"
            dealType = "weekly"
            imageUrl = "https://images.unsplash.com/photo-1569171206684-dfb2749d96fd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDF8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60"
        }

        val car8 = Cars()
        car8.apply {
            id = "3"
            type = "Mustang"
            model = "AMG 340"
            dealType = "monthly"
            imageUrl = "https://images.unsplash.com/photo-1592797520856-883837ddd186?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDV8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60"
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


        val car12 = Cars()
        car12.apply {
            id = "3"
            type = "Asphalt"
            model = "AMG 340"
            dealType = "Daily"
            imageUrl = "https://images.unsplash.com/photo-1568605117036-5fe5e7bab0b7?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80"
        }

        val car13 = Cars()
        car13.apply {
            id = "3"
            type = "Mustang"
            model = "AMG 340"
            dealType = "weekly"
            imageUrl = "https://images.unsplash.com/photo-1569171206684-dfb2749d96fd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDF8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=500&q=60"
        }

        cars.add(car)
        cars.add(car1)
        cars.add(car2)
        cars.add(car3)
        cars.add(car11)
        cars.add(car10)
        cars.add(car6)
        cars.add(car7)
        cars.add(car8)
        cars.add(car9)

        cars.add(car13)
        cars.add(car12)
        cars.add(car13)
        cars.add(car9)


        return cars
    }
}