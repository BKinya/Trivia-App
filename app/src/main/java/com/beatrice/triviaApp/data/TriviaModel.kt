package com.beatrice.triviaApp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trivia")
data class TriviaModel(
    @PrimaryKey
    val id: Int,
    val triviaText: String
)