package com.vishnu.dagger.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vishnu.dagger.R
import com.vishnu.dagger.model.GamesModel
import kotlinx.android.synthetic.main.item_games.view.*

class GamesAdapter(val onclickListener: OnclickListener) : ListAdapter<GamesModel.Result, GamesAdapter.ViewHolder>(diffUtilCallBack()) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_games, parent, false)
        return GamesAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            Glide.with(context)
                .load(getItem(position).backgroundImage)
                .into(roundedImageView)

            tv_title.text=getItem(position).name
            tv_rating.text=getItem(position).rating.toInt().toString()

            cv_lay.setOnClickListener {
                onclickListener.onGamesClicked(getItem(position))
            }
        }

    }

    class diffUtilCallBack : DiffUtil.ItemCallback<GamesModel.Result>() {
        override fun areItemsTheSame(oldItem: GamesModel.Result, newItem: GamesModel.Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GamesModel.Result, newItem: GamesModel.Result): Boolean {
            return areItemsTheSame(oldItem, newItem)
        }

    }
    interface OnclickListener{
        fun onGamesClicked(games : GamesModel.Result)
    }
}