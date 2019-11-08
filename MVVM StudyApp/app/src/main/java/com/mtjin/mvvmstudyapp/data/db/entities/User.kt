package com.mtjin.mvvmstudyapp.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//data class란 데이터만 담기 위한 클래스이다.
/*
* data class는 일반 클래스에 없는 기능들을 지원해준다.

1. 프로퍼티 생성

getter/setter을 자동으로 작성해준다.

var, val로 선언된 변수들을 자동으로 만들어준다.


2. componentN()

component함수를 작성해준다.

component함수는 분리 선언을 할 때 필요한 함수이다.

여기서 분리선언이라는 말에 대해 알 필요가 있다.
* */
const val CURRENT_USER_ID = 0

@Entity
data class User(
    var id: Int? = null,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var email_verified_at: String? = null,
    var created_at: String? = null,
    var updated_at: String? = null
){
    //Id가 자동증가되지않게함, 여러 유저가 아닌 한 유저만 localdatabase에 접근이 가능하게 하기위해
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}
