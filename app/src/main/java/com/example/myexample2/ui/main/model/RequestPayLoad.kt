package com.example.myexample2.ui.main.model

import com.google.gson.annotations.SerializedName

data class RequestPayLoad(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("job")
    val job: String = ""
)