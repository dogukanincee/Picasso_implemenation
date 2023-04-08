package com.dogukanincee.picasso_implemenation

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

/**
 * A RecyclerView adapter to display a list of images using the Picasso library.
 * The adapter maintains a list of images and provides methods to add images to the list.
 * Each item in the RecyclerView is represented by an ImageViewHolder, which contains an ImageView
 * to display the image.
 */
class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    /**
     * The list of images to display in the RecyclerView.
     */
    private val images = mutableListOf<Drawable>()

    /**
     * Adds a new image to the list of images and notifies the adapter that the data set has changed.
     *
     * @param drawable the Drawable object representing the image to add to the list.
     */
    fun addImage(drawable: Drawable) {
        images.add(drawable)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * The ImageView used to display the image.
         */
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        /**
         * Binds the given Drawable object to the ImageView.
         *
         * @param drawable the Drawable object representing the image to bind to the ImageView.
         */
        fun bind(drawable: Drawable) {
            imageView.setImageDrawable(null) // Clear previous image
            imageView.setImageDrawable(drawable)
        }
    }
}