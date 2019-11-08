package com.mtjin.mvvmstudyapp.ui.auth

import androidx.lifecycle.LiveData

interface AuthListener {
    fun onStarted() //로그인시 progressbar
    fun onSuccess(loginResponse: LiveData<String>) //로그인 성공시
    fun onFailure(message: String)// 로그인 실패시
}