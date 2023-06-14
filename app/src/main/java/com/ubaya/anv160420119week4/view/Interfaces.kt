package com.ubaya.anv160420119week4.view

import android.view.View
import com.ubaya.anv160420119week4.model.Student

interface ButtonDetailClickListener {
    fun onButtonDetailClick(v: View)
}

interface NotifClickListener {
    fun onClickNotif(v: View, s: Student)
}

interface ButtonUpdateClickListener {
    fun onUpdateClick(v: View, obj: Student)
}
