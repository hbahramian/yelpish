package edu.iu.habahram.yelpish

import androidx.recyclerview.widget.DiffUtil
import edu.iu.habahram.yelpish.model.YelpRestaurant


class RestaurantDiffItemCallback : DiffUtil.ItemCallback<YelpRestaurant>() {
    override fun areItemsTheSame(oldItem: YelpRestaurant, newItem: YelpRestaurant)
            = (oldItem.name == newItem.name)
    override fun areContentsTheSame(oldItem: YelpRestaurant, newItem: YelpRestaurant) = (oldItem == newItem)
}