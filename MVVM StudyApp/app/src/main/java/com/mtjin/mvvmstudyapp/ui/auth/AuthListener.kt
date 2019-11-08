package com.mtjin.mvvmstudyapp.ui.auth

import androidx.lifecycle.LiveData
import com.mtjin.mvvmstudyapp.data.db.entities.User

interface AuthListener {
    fun onStarted() //로그인시 progressbar
    fun onSuccess(user: User) //로그인 성공시
    fun onFailure(message: String)// 로그인 실패시
}