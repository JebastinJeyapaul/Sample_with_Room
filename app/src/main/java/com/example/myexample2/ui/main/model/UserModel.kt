package com.example.myexample2.ui.main

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("page")
    val page: String = "",
    val total: String = "",
    val total_pages: String = "",
    val createdAt: String = "",
    val data: List<UserData>? = null)

data class UserData(
    val id: String = "",
    val email: String = "")