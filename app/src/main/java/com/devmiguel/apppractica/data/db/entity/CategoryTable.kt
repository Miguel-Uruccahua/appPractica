package com.devmiguel.apppractica.data.db.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Categoria")
data class CategoryTable (
    @PrimaryKey
    @SerializedName("id")
    var id : Int ? = null,
    @SerializedName("name")
    var name: String ? = null,
    @SerializedName("image")
    var image: String? = null
){
}