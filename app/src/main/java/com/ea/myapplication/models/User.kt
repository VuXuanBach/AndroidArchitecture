package com.ea.myapplication.models

import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.widget.ImageView
import com.bumptech.glide.Glide

class User {
    var email = ObservableField<String>()
    var name = ObservableField<String>()
    var profileImg = ObservableField<String>()
}

@BindingAdapter("profileImg")
fun loadImage(view: ImageView, profileIamg: String) {
    Glide.with(view.context).load(profileIamg).into(view)
}