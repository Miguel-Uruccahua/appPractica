package com.devmiguel.apppractica.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devmiguel.apppractica.data.RestApi
import com.devmiguel.apppractica.data.db.dao.CategoryDao
import com.devmiguel.apppractica.data.db.entity.CategoryTable
import com.devmiguel.apppractica.data.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
       private val restApi: RestApi,
       private val categoryDao: CategoryDao
) : ViewModel() {

        val category = MutableLiveData<List<CategoryTable>>()

        fun getCategory(){
             viewModelScope.launch {
                  runCatching {
                      restApi.getCategory()
                  }.onSuccess {
                      category.postValue(it)
                      categoryDao.insertMultiple(*it.toTypedArray())
                  }  .onFailure {
                      Log.e("Error","${it}")
                  }
             }
        }

}