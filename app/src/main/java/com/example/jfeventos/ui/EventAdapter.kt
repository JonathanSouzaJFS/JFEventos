package com.example.jfeventos.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.jfeventos.databinding.ItemEventBinding
import com.example.jfeventos.model.Event
import kotlin.collections.ArrayList

class EventAdapter(
    private val context: Context,
    private val list: ArrayList<Event>,
    private val onItemClickListener: ((event: Event) -> Unit)
) : RecyclerView.Adapter<EventAdapter.DataViewHolder>() {

    private var lastPosition = -1
    lateinit var listEventFull: ArrayList<Event>

    inner class DataViewHolder(
        private val binding: ItemEventBinding,
        private val onItemClickListener: ((event: Event) -> Unit)
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.event = event

            binding.root.setOnClickListener {
                onItemClickListener.invoke(event)
            }
        }
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            val animation: Animation =
                AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemEventBinding.inflate(inflater, parent, false)
        return DataViewHolder(binding, onItemClickListener)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(list[position])
        setAnimation(holder.itemView, position)
    }

    fun addEvent(events: List<Event>) {
        list.addAll(events)
        listEventFull = ArrayList(list)
    }

    fun clearItems() = list.clear()

    fun removeItem(event: Event) = list.remove(event)

}
