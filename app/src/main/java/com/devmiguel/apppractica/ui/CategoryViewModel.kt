package com.devmiguel.apppractica.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devmiguel.apppractica.data.RestApi
import com.devmiguel.apppractica.data.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
       private val restApi: RestApi
) : ViewModel() {

        val category = MutableLiveData<List<Category>>()

        fun getCategory(){
             viewModelScope.launch {
                  runCatching {
                          restApi.getCategory()
                  }.onSuccess {
                          category.postValue(it)
                  }  .onFailure {
                          Log.e("Error","${it}")
                  }
             }
        }

}