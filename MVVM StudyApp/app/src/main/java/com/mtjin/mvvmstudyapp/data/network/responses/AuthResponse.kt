package com.mtjin.mvvmstudyapp.data.network.responses

import com.mtjin.mvvmstudyapp.data.db.entities.User


data class AuthResponse(
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)