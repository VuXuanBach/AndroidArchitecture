package com.ea.myapplication.listener

import android.view.View
import android.widget.Toast
import com.ea.myapplication.models.User

class MyClickHandler {
    fun onFABClicked(view: View, user: User) {
        Toast.makeText(view.context, "FAB clicked!", Toast.LENGTH_SHORT).show()
        user.email.set("bach2@gmail.com")
        user.name.set("bach2")
    }
}