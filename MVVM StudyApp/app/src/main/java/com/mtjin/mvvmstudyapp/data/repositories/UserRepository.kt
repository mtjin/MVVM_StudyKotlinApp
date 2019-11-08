package com.mtjin.mvvmstudyapp.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mtjin.mvvmstudyapp.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    //이 Repository 메소드는 백엔드(서버)와 통신하고 ViewModel에서 이 메소드를 호출해야한다.
    fun userLogin(email: String, password: String): LiveData<String> {
        val loginResponse = MutableLiveData<String>()

        MyApi().userLogin(email, password)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                   loginResponse.value = t.message
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if(response.isSuccessful){
                        loginResponse.value = response.body()?.string()
                    }else{
                        loginResponse.value = response.errorBody()?.string()
                    }
                }

            })
        //return LiveData
        return loginResponse
    }
}