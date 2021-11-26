package com.beatrice.triviaApp.data

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        TriviaModel::class
    ],
    version = 1
)
abstract class TriviaDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: TriviaDatabase? = null
        fun getInstance(context: Context): TriviaDatabase {
            var instance = INSTANCE
            if (instance == null) {
                Log.d("MDATABASE", "getting here")
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    TriviaDatabase::class.java,
                    "app_database"
                ).build()

                INSTANCE = instance
            }
            return instance
        }
    }

    abstract fun triviaDao(): TriviaDao
}