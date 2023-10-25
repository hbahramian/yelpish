package edu.iu.habahram.yelpish

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import edu.iu.habahram.yelpish.databinding.RestaurantItemBinding
import edu.iu.habahram.yelpish.model.YelpRestaurant


class RestaurantsAdapter(val context: Context) :
    ListAdapter<YelpRestaurant, RestaurantsAdapter.ItemViewHolder>(RestaurantDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ItemViewHolder = ItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, context)
    }

    class ItemViewHolder(val binding: RestaurantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun inflateFrom(parent: ViewGroup): ItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RestaurantItemBinding.inflate(layoutInflater, parent, false)
                return ItemViewHolder(binding)
            }
        }

        fun bind(restaurant: YelpRestaurant, context: Context) {
            binding.tvName.text = restaurant.name
            binding.ratingBar.rating = restaurant.rating.toFloat()
            binding.tvNumReviews.text = "${restaurant.numReviews} Reviews"
            binding.tvAddress.text = restaurant.location.address
            binding.tvCategory.text = restaurant.categories[0].title
            binding.tvDistance.text = restaurant.displayDistance()
            binding.tvPrice.text = restaurant.price
//            Glide.with(context).load(restaurant.imageUrl).into(binding.imageView)
            Glide.with(context).load(restaurant.imageUrl)
                .apply(
                    RequestOptions().transforms(
                        CenterCrop(), RoundedCorners(20)
                    )
                )
                .into(binding.imageView)


        }


    }
}