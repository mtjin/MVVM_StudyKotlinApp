package com.mtjin.mvvmstudyapp.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mtjin.mvvmstudyapp.data.network.MyApi
import com.mtjin.mvvmstudyapp.data.network.responses.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    //이 Repository 메소드는 백엔드(서버)와 통신하고 ViewModel에서 이 메소드를 호출해야한다.
    suspend fun userLogin(email: String, password: String): Response<AuthResponse> {
       return MyApi().userLogin(email,password)
    }
}