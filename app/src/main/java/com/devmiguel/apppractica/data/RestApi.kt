package com.devmiguel.apppractica.data

import com.devmiguel.apppractica.data.db.entity.CategoryTable
import com.devmiguel.apppractica.data.model.Category
import retrofit2.http.Body
import retrofit2.http.GET

interface RestApi {

    @GET("categories")
    suspend fun getCategory(): List<CategoryTable>

}