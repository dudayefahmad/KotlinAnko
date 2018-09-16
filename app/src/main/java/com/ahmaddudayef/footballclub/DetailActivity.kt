package com.ahmaddudayef.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.ahmaddudayef.footballclub.data.Item
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.notification_template_lines_media.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.w3c.dom.Text

/**
 * Created by Ahmad Dudayef on 9/5/2018.
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val item = intent.extras.getParcelable<Item>("item")
        val detailUi = DetailActivityUI()
        detailUi.setContentView(this)
        detailUi.nameCLub.text = item.name
        detailUi.textView.text = item.description
        Glide.with(this).load(item.image).into(detailUi.imageView)
        toast("So is ${item.name} your favourite football club ???")
    }

    class DetailActivityUI : AnkoComponent<DetailActivity> {
        lateinit var imageView: ImageView
        lateinit var nameCLub: TextView
        lateinit var textView: TextView

        override fun createView(ui: AnkoContext<DetailActivity>): View = with(ui) {
            verticalLayout {
                imageView = imageView {
                    imageResource = R.drawable.img_madrid
                    contentDescription = resources.getString(R.string.realmadrid)
                }.lparams{
                    width = wrapContent
                    height = dip(50)
                    gravity = Gravity.CENTER
                    margin = dip(10)
                }

                imageView

                nameCLub = textView {
                    text = "Real Madrid"
                }.lparams {
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                    gravity = Gravity.CENTER
                }

                textView = textView {
                    text = "Real Madrid"
                }.lparams {
                    width = wrapContent
                    height = wrapContent
                    margin = dip(10)
                    gravity = Gravity.CENTER
                }

                textView
            }
        }

    }
}