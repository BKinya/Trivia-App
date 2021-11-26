package com.beatrice.trivial_app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 1
)
abstract class TriviaDatabase : RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: TriviaDatabase? = null
        fun getInstance(context: Context): TriviaDatabase {
            var instance = INSTANCE
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    TriviaDatabase::class.java,
                    "app_database"
                )
                    .build()

                INSTANCE = instance
            }
        return instance
        }
    }
}