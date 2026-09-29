package com.example.myapplication.data

import androidx.annotation.DrawableRes

data class PersonalInfo(
    val mssv: String,
    val fullName: String,
    @DrawableRes val imageRes: Int? = null,
    val imagePlaceholder: String = "👤"
)

data class UserCredentials(
    val username: String,
    val password: String
)

object AuthConstants {
    const val CORRECT_USERNAME = "admin"
    const val CORRECT_PASSWORD = "password123"
    
    val DEFAULT_USER = PersonalInfo(
        mssv = "21110800", // Example MSSV
        fullName = "Nguyen Van A",
        imageRes = null // Using placeholder for now
    )
}
