package com.mtjin.mvvmstudyapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.mtjin.mvvmstudyapp.R
import com.mtjin.mvvmstudyapp.databinding.ActivityLoginBinding
import com.mtjin.mvvmstudyapp.util.toast

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //데이터바인딩
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        //of()는 현재 액티비티를 파라미터로서 가져올 수 있고 액티비티안에 들어 갈 수 있게해준다.
        //액티비티 안에 들어가고 get()을 통해 viewModel을 가져올 수 있다. (매개변수로 우리가 정의한 뷰모델 클래스를 가져올 수 있음)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        //set this viewmodel as our binding viewmodel
        binding.viewmodel = viewModel
        //UI로 부터 data를 가져오기위해
        viewModel.authListener = this
    }

    override fun onStarted() {
        toast("로그인 중")
    }

    override fun onSuccess() {
        toast("로그인 성공")
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}
