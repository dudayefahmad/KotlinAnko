package com.ahmaddudayef.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ahmaddudayef.footballclub.adapter.FootballAdapter
import com.ahmaddudayef.footballclub.data.Item
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainUi = MainActivityUI()
        mainUi.setContentView(this)

        val items = initData()

        mainUi.recyclerview.adapter = FootballAdapter(items) {
            startActivity<DetailActivity>("item" to it)
        }
    }

    private fun initData(): List<Item> {
        val name = resources.getStringArray(R.array.club_name)
        val description = resources.getStringArray(R.array.club_description)
        val image = resources.obtainTypedArray(R.array.club_image)

        val result = name.mapIndexed { i, itemName ->
            Item(itemName, image.getResourceId(i, 0), description[i])
        }

        image.recycle()
        return result
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        lateinit var recyclerview: RecyclerView
        override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
            verticalLayout {
                recyclerview = recyclerView {
                    lparams(matchParent)
                    layoutManager = LinearLayoutManager(ui.ctx)
                }.lparams(matchParent)

                recyclerview
            }
        }

    }
}
