package com.ea.myapplication

import android.content.Context
import android.databinding.DataBindingUtil
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bumptech.glide.load.Option
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.ResourceDecoder
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapResource
import com.bumptech.glide.request.RequestOptions.option
import com.ea.myapplication.daggers.DaggerAppComponent
import com.ea.myapplication.databinding.ActivityMainBinding
import com.ea.myapplication.glide.GlideApp
import com.ea.myapplication.listener.MyClickHandler
import com.ea.myapplication.models.Info
import com.ea.myapplication.models.User
import javax.inject.Inject
import javax.inject.Named

// https://medium.com/mindorks/android-architecture-components-room-viewmodel-and-livedata-50611793e4a9
class MainActivity : AppCompatActivity() {

//    private val target: GlideDrawableImageViewTarget by lazy {
//        object : GlideDrawableImageViewTarget(videoPreviewImage, 1) {
//            override fun setResource(resource: GlideDrawable?) {
//                ImageUtils.calculateImageHeight(view, resource)
//                super.setResource(resource)
//            }
//        }
//    }

    @Inject
    @field:Named("1")
    lateinit var info1: Info

    @Inject
    @field:Named("2")
    lateinit var info2: Info

    companion object {
        val GALLERY_DECODER: Option<Boolean> = Option.memory("abc")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAppComponent.create().inject(this)
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.test = "abc"
        binding.user = User().apply {
            this.profileImg.set("https://api.androidhive.info/images/nature/david.jpg")
        }
        binding.handler = MyClickHandler()

//        String.format(resources.getString(R.string.validation_error_min_digits), 1)
        GlideApp.with(this)
//            .setDefaultRequestOptions(GlideOptions().decode(GalleryDecoder::class.java))
            .asBitmap()
//            .load(R.drawable.giphy)
            .load("https://cloud.githubusercontent.com/assets/5911164/11127862/8dd736e6-895d-11e5-9522-ac0da09c6243.png")
            .apply(option(GALLERY_DECODER, true))
//            .into(image_view)

        Log.e("bachea", info1.text)
        Log.e("bachea", info2.text)


    }

    open class GalleryDecoder(
        private val context: Context,
        private val bitmapPool: BitmapPool
    ) : ResourceDecoder<Any, Bitmap> {

        override fun decode(source: Any, width: Int, height: Int, options: Options): Resource<Bitmap>? {
            return BitmapResource.obtain(BitmapFactory.decodeResource(context.resources, R.drawable.giphy), bitmapPool)
        }

        override fun handles(source: Any, options: Options): Boolean = options.get(GALLERY_DECODER) ?: false

    }
}
