package com.devmiguel.apppractica.di

import com.devmiguel.apppractica.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun provideCategoryDao(database: AppDatabase)= database.categoryDao()
}