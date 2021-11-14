package com.vishnu.dagger.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vishnu.dagger.R
import com.vishnu.dagger.model.CategoryModel
import kotlinx.android.synthetic.main.item_cat.view.*

class CategoryAdapter : ListAdapter<CategoryModel, CategoryAdapter.ViewHolder>(diffUtilCallback()) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        holder.itemView.apply {
            iv_cat.setImageResource(R.drawable.favorite)
        }
    }

}

class diffUtilCallback : DiffUtil.ItemCallback<CategoryModel>() {
    override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }

}