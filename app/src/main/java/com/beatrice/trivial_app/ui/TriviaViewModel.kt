package com.beatrice.trivial_app.ui

import android.content.Context
import androidx.lifecycle.*
import com.beatrice.trivial_app.data.TriviaModel
import com.beatrice.trivial_app.repository.TriviaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TriviaViewModel: ViewModel(){
    private val repository = TriviaRepository()

    private val trivia = MutableLiveData<TriviaModel?>()
    val mTrivia: LiveData<TriviaModel?> get() = trivia

    fun getTrivia(triviaId: Int, context: Context){
        viewModelScope.launch {
            val result = repository.getTrivia(triviaId, context)
            trivia.postValue(result)
        }
    }

    fun saveTrivia(trivia: List<TriviaModel>, context: Context){
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveTrivia(trivia, context)
        }
    }

}