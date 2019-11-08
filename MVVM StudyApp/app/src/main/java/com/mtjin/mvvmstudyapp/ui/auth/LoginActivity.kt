package com.mtjin.mvvmstudyapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mtjin.mvvmstudyapp.R
import com.mtjin.mvvmstudyapp.data.db.entities.User
import com.mtjin.mvvmstudyapp.databinding.ActivityLoginBinding
import com.mtjin.mvvmstudyapp.util.hide
import com.mtjin.mvvmstudyapp.util.show
import com.mtjin.mvvmstudyapp.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //데이터바인딩
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        //of()는 현재 액티비티를 파라미터로서 가져올 수 있고 액티비티안에 들어 갈 수 있게해준다.
        //액티비티 안에 들어가고 get()을 통해 viewModel을 가져올 수 있다. (매개변수로 우리가 정의한 뷰모델 클래스를 가져올 수 있음)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        //set this viewmodel as our binding viewmodel (xml의 binding.viewmodel에 내가 생성한 viewmodel을 매칭시킴)
        binding.viewmodel = viewModel
        //UI로 부터 data를 가져오기위해
        viewModel.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        toast("${user.name} is Logged In")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}
