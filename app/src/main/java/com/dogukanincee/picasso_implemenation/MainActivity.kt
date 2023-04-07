package com.dogukanincee.picasso_implemenation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * This activity demonstrates how to use Picasso library to load an image from a URL
 * into an ImageView in Android.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageView)
        loadImageUsingPicasso(imageView)
    }

    /**
     * Loads an image from the provided URL using Picasso library and sets it as the
     * source of the provided ImageView. If the image cannot be loaded, a placeholder image
     * is displayed instead.
     *
     * @param imageView the ImageView to load the image into
     */
    private fun loadImageUsingPicasso(imageView: ImageView) {
        //This link is provided to get a random image each time it is accessed
        val imageUrl = "https://picsum.photos/1080/1920"

        Picasso.get()
            .load(imageUrl)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.error_image)
            .into(imageView)
    }
}