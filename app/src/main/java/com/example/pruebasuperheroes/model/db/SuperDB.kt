package com.example.pruebasuperheroes.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pruebasuperheroes.model.pojo.SuperHeroe

@Database(entities = arrayOf(SuperHeroe::class), version = 1)
abstract class SuperDB : RoomDatabase() {

    abstract fun dao(): SuperDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: SuperDB? = null

        fun getDatabase(context: Context): SuperDB {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SuperDB::class.java,
                    "database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}