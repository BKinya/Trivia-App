package com.beatrice.triviaApp.repository

import android.content.Context
import com.beatrice.triviaApp.data.TriviaDatabase
import com.beatrice.triviaApp.data.TriviaModel

class TriviaRepository(
) {

    suspend fun getTrivia(triviaId: Int, context: Context): TriviaModel?{
        val database = TriviaDatabase.getInstance(context)
        val dao = database.triviaDao()
        return dao.getTriviaById(triviaId)
    }

    suspend fun saveTrivia(trivia: List<TriviaModel>, context: Context){
        val database = TriviaDatabase.getInstance(context)
        val dao = database.triviaDao()
        return dao.saveTrivia(trivia)
    }
}