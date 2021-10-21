package com.sklagat46.driveit.ui.cars

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sklagat46.driveit.R
import com.sklagat46.driveit.ui.home.model.Cars
import kotlinx.android.synthetic.main.item_top_deals.view.*

class AvailableCarsAdapter(
    private val context: Context,
    private var list: List<Cars>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AvailableCarsViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_top_deals,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]

        if (holder is AvailableCarsAdapter.AvailableCarsViewHolder) {


            Glide
                .with(context)
                .load(model.imageUrl)
                .centerCrop()
                .placeholder(R.drawable.car_ferarri)
                .into(holder.itemView.iv_item_car_image);

            holder.itemView.tv_item_car_name.text = model.type
            holder.itemView.tv_model_id.text = model.model
            holder.itemView.tv_deal_type.text = model.dealType

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class AvailableCarsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

    }
}