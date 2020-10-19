package com.example.internettelevision

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // custom actionbar
        MainActivity.getInstance().setTitle("Home")
        var colorDrawable = ColorDrawable(Color.parseColor("#009688"))
        MainActivity.getInstance().getSupportActionBar()?.setBackgroundDrawable(colorDrawable)

        // set up slidshow
        var imageView = MainActivity.getInstance().findViewById<ImageView>(R.id.imageView)
        var context = imageView.context
        var image = arrayOf<Int>(MainActivity.getInstance().resources.getIdentifier("image1","drawable",context.packageName),
            MainActivity.getInstance().resources.getIdentifier("image2","drawable",context.packageName),
            MainActivity.getInstance().resources.getIdentifier("image3","drawable",context.packageName))

        // slideshow of the three images
        val handler = Handler()
        var i = 0
        handler.postDelayed(object : Runnable {
            override fun run() {
                imageView.setImageResource(image.get(i))
                handler.postDelayed(this, 3000)
                i++
                if (i > 2)
                    i = 0
            }
        }, 3000)

    }

}