package com.devmiguel.apppractica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devmiguel.apppractica.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_category.*
import kotlin.random.Random

@AndroidEntryPoint
class Category : AppCompatActivity() {

    private val viewmModel by viewModels<CategoryViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        viewmModel.getCategory()

        buttonrandom.setOnClickListener{
            viewmModel.getCategory()
        }

        observeGetCategory()
    }

    private fun observeGetCategory(){
        viewmModel.category.observe(this){
            val number = Random.nextInt(it.size)+1
            it.find{ it.id==number }.let{
                resultTitle.text = it!!.name ?: "No encontrado"
                Glide.with(this)
                    .load(it.image)
                    .apply(
                        RequestOptions().circleCrop().placeholder(R.drawable.default_avatar)
                            .error(R.drawable.default_avatar)
                    )
                    .into(resultPicture)
            }
        }
    }


    override fun onResume() {
        super.onResume()
        viewmModel.getCategory()
    }

}