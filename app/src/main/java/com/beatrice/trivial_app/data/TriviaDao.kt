package com.beatrice.trivial_app.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TriviaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveTrivia(trivia: List<TriviaModel>)

    @Query("SELECT * FROM trivia WHERE id = :triviaId")
    fun getTriviaById(triviaId: Int): TriviaModel?
}