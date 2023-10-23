package com.devmiguel.apppractica.data.model

import com.google.gson.annotations.SerializedName

data class Category (
    @SerializedName("id")
    var id : Int ? = null,
    @SerializedName("name")
    var name: String ? = null,
    @SerializedName("image")
    var image: String? = null
    ){}