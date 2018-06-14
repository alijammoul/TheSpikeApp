package com.example.thespikeapp


import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class SwipeAdapter constructor(var context: Context) : PagerAdapter() {

    private val images = arrayOf(R.drawable.map, R.drawable.notification, R.drawable.chart)
    val mapTextDescription = "Our location tracking \nalgorithms track when you\'re at \na restaurant to remind you of \nyour medicine."
    val notificationsTextDescription = "We notify you to take your \nmedicine whenever you visit a \nrestaurant, cafe or any other \ndining place."
    val chartTextDescription = "All your data is safely logged in \nour app with available statistics \nto help you understand your \ndiabetic condition better."
    private val description = arrayOf<String>(mapTextDescription, notificationsTextDescription, chartTextDescription)
    private lateinit var layoutinflater: LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as ConstraintLayout
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        Log.d("Main", "Called Instantiate")
        layoutinflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = layoutinflater.inflate(R.layout.swipe_layout, container, false)
        var image = view.findViewById<ImageView>(R.id.image)
        var text = view.findViewById<TextView>(R.id.text)
        image.setImageResource(images[position])
        text.text = description[position]
        container.addView(view)


        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        Log.d("Main", "Called Destroyed")
        container.removeView(`object` as ConstraintLayout)
    }
}