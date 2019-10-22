package com.mtjin.mvvmstudyapp.util

import android.content.Context
import android.widget.Toast

//Contet extenstion
fun Context.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}