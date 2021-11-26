package com.beatrice.trivial_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trivia")
data class TriviaModel(
    @PrimaryKey
    val id: Int,
    val triviaText: String
)