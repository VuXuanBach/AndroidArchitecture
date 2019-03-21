package com.ea.myapplication.glide

import android.content.Context
import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.ea.myapplication.MainActivity


@GlideModule
class MyAppGlideModule : AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.prepend(Any::class.java, Bitmap::class.java,
            MainActivity.GalleryDecoder(context, glide.bitmapPool)
        )
    }
}
