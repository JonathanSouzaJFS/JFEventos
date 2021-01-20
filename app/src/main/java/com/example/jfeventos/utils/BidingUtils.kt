package com.example.jfeventos.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.jfeventos.R
import com.squareup.picasso.Picasso

class BidingUtils {

    companion object {
        @JvmStatic
        @BindingAdapter("bind:picassoLoad")
        fun loadImageView(image: ImageView, avatarUrl: String?) {
            if (avatarUrl != null) {
                Picasso.get().load(avatarUrl)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(image)
            }
        }
    }
}

