package com.example.thespikeapp


import android.content.Context
import android.media.Image
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class SwipeAdapter constructor(var context: Context) : PagerAdapter() {

    private val images = arrayOf(R.drawable.map,R.drawable.notification,R.drawable.chart)
    val mapText = "Our location tracking algorithms track when you\'re at a restaurant to remind you of your medicine."
    val notificationsText ="We notify you to take your medicine whenever you visit a restaurant, cafe or any other dining place."
    val chartText = "All your data is safely logged in our app with available statistics \nto help you understand your diabetic condition better."
    private val description = arrayOf<String>(mapText,notificationsText,chartText)
    private lateinit var layoutinflater: LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as ConstraintLayout
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        Log.d("Main","Called Instantiate")
        layoutinflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layoutinflater.inflate(R.layout.swipe_layout,container,false)
        var image = view.findViewById<ImageView>(R.id.image)
        var text = view.findViewById<TextView>(R.id.text)
        image.setImageResource(images[position])
        text.text=description[position]
        container.addView(view)


        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        Log.d("Main","Called Destroyed")
        container.removeView(`object` as ConstraintLayout)
    }
}