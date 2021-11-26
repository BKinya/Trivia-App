package com.beatrice.trivial_app.ui

import android.content.Context
import androidx.lifecycle.*
import com.beatrice.trivial_app.data.TriviaModel
import com.beatrice.trivial_app.repository.TriviaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TriviaViewModel : ViewModel() {
    private val repository = TriviaRepository()
    var triviaId = 0

    private val _trivia = MutableLiveData<TriviaModel?>()
    val trivia: LiveData<TriviaModel?> get() = _trivia

    fun getTrivia(context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getTrivia(triviaId, context)
            _trivia.postValue(result)
        }
    }

    fun saveTrivia(trivia: List<TriviaModel>, context: Context) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveTrivia(trivia, context)
        }
    }

}