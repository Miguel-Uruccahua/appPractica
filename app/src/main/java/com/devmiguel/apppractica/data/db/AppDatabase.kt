package com.devmiguel.apppractica.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devmiguel.apppractica.data.db.dao.CategoryDao
import com.devmiguel.apppractica.data.db.entity.CategoryTable

@Database(
    entities = [
        CategoryTable::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
        abstract fun categoryDao(): CategoryDao
}