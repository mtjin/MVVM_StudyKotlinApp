package com.mtjin.mvvmstudyapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.mtjin.mvvmstudyapp.data.repositories.UserRepository

class AuthViewModel : ViewModel(){
    /*layout파일에서 text를 viewmodel.email로 설정함으로써 자동으로 이 변수들에 값이 할당된다.*/
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("이메일 혹은 비밀번호가 틀립니다.")
            return
        }
        //성공시 ViewModel 에서 Repository 호출  (뷰모델과 레포지토리가 의존성이 생겨서 나쁜예시임 나중에 injection 배우고 수정할 예정)
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)

    }
}