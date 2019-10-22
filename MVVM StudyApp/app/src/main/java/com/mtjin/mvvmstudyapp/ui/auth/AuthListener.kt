package com.mtjin.mvvmstudyapp.ui.auth

interface AuthListener {
    fun onStarted() //로그인시 progressbar
    fun onSuccess() //로그인 성공시
    fun onFailure(message: String)// 로그인 실패시
}