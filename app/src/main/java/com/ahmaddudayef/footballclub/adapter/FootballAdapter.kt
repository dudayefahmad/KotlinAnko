package com.ahmaddudayef.footballclub.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmaddudayef.footballclub.data.Item
import com.ahmaddudayef.footballclub.ui.ListItem
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext

/**
 * Created by Ahmad Dudayef on 9/5/2018.
 */

class FootballAdapter(private val items: List<Item>, private val listener: (Item) -> Unit):
        RecyclerView.Adapter<FootballAdapter.FootballViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballViewHolder{
        val ui = AnkoContext.create(parent.context, parent)
        val listItem = ListItem()
        val view = listItem.createView(ui)

        return FootballViewHolder(view, listItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FootballViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class FootballViewHolder(val view: View, private val listItem: ListItem): RecyclerView.ViewHolder(view) {
        fun bindItem(item: Item, listener: (Item) -> Unit){
            listItem.textView.text = item.name
            Glide.with(itemView.context).load(item.image).into(listItem.imageView)

            itemView.setOnClickListener {
                listener(item)
            }
        }
    }

}