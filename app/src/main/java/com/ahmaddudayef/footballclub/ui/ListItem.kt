package com.ahmaddudayef.footballclub.ui

import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.ahmaddudayef.footballclub.R
import org.jetbrains.anko.*

/**
 * Created by Ahmad Dudayef on 9/5/2018.
 */
class ListItem : AnkoComponent<ViewGroup> {

    lateinit var imageView: ImageView
    lateinit var textView: TextView

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        linearLayout {
            padding = dip(16)
            orientation = LinearLayout.HORIZONTAL

            imageView = imageView {
                imageResource = R.drawable.img_madrid
                contentDescription = resources.getString(R.string.realmadrid)
            }.lparams {
                width = dip(50)
                height = dip(50)
            }

            imageView

            textView = textView {
                text = "Real Madrid"
            }.lparams {
                width = wrapContent
                height = wrapContent
                margin = dip(10)
                gravity = Gravity.CENTER_VERTICAL
            }

            textView
        }
    }

}