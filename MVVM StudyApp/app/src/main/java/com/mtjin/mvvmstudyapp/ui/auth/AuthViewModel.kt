package com.mtjin.mvvmstudyapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.mtjin.mvvmstudyapp.data.repositories.UserRepository
import com.mtjin.mvvmstudyapp.util.Coroutines

class AuthViewModel : ViewModel(){
    /*layout파일에서 text를 viewmodel.email로 설정함으로써 자동으로 이 변수들에 값이 할당된다.*/
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("이메일 혹은 비밀번호를 써주세요")
            return
        }
        Coroutines.main{
            val response = UserRepository().userLogin(email!!, password!!)
            if(response.isSuccessful){
                authListener?.onSuccess(response.body()?.user!!)
            }else{
                authListener?.onFailure("Error Code: ${response.code()}")
            }
        }
    }
}