package com.dogukanincee.picasso_implemenation

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

/**
 * This activity demonstrates how to use Picasso library and RecyclerView to load and display
 * multiple images from the same URL into an Android app.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ImageAdapter()
        recyclerView.adapter = adapter

        loadImagesUsingPicasso()
    }

    /**
     * Loads multiple images from the provided URL using Picasso library and sets them as the
     * source of ImageViews that are added to the RecyclerView.
     */
    private fun loadImagesUsingPicasso() {
        for (i in 1..10) { // Load 10 images
            val imageUrl = "https://picsum.photos/1080/1920?image=$i" // Append position to URL
            Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .into(object : com.squareup.picasso.Target {
                    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                        val imageView = ImageView(this@MainActivity)
                        imageView.setImageBitmap(bitmap)
                        adapter.addImage(imageView.drawable)
                    }

                    override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                        // handle error
                    }

                    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                        // do nothing
                    }
                })
        }
    }
}