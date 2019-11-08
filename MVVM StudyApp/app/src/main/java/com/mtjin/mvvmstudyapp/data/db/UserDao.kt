package com.mtjin.mvvmstudyapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mtjin.mvvmstudyapp.data.db.entities.CURRENT_USER_ID
import com.mtjin.mvvmstudyapp.data.db.entities.User

@Dao
interface UserDao{
    //키가 중복되어 충돌날경우 원래 현재 저장되 있는 유저를 overwrite함
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User) : Long

    @Query("SELECT * FROM  user WHERE uid = $CURRENT_USER_ID")
    fun getUser() : LiveData<User>
}