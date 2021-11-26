package com.beatrice.triviaApp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.beatrice.triviaApp.R
import com.beatrice.triviaApp.data.TriviaModel

class TriviaActivity : AppCompatActivity() {
    private val triviaViewModel: TriviaViewModel by viewModels()
    private lateinit var triviaTextView: TextView
    private lateinit var buttonView: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        triviaTextView = findViewById(R.id.triviaTextView)
        buttonView = findViewById(R.id.button)
        saveTrivia()
        onButtonClicked()
        observeTrivia()
    }


    private fun saveTrivia() {
        triviaViewModel.saveTrivia(trivia, this)
    }

    private fun onButtonClicked(){
        buttonView.setOnClickListener {
            var triviaId = triviaViewModel.triviaId
            if (triviaId < 10){
                triviaId += 1
            }else{
                triviaId = 0
                triviaTextView.text = "Hello World!"
            }
            Log.d("TRIVIAID", "is $triviaId ")
            triviaViewModel.triviaId = triviaId
            triviaViewModel.getTrivia(this)
        }
    }

    private fun observeTrivia(){
        triviaViewModel.trivia.observe(this){ trivia ->
            trivia?.let {
                Log.d("TRIVIAID", "is ${it.triviaText}")
                triviaTextView.text = it.triviaText
            }
        }
    }

    private val trivia = listOf(
        TriviaModel(
            1,
            "A reservoir in space holds 140 trillion times the amount of water in Earth's oceans."
        ),
        TriviaModel(
            2,
            "The word \"muscle\" comes from a Latin term meaning \"little mouse.\""
        ),
        TriviaModel(
            3,
            "Tic Tac mints are named after the sound their container makes."
        ),
        TriviaModel(
            4,
            "The largest volcano in the solar system is three times taller than Mount Everest."
        ),
        TriviaModel(
            5,
            "An 11-year-old is responsible for naming  Pluto."
        ),
        TriviaModel(
            6,
            "On Mars, sunsets are blue."
        ),
        TriviaModel(
            7,
            "There's a Russian village where every resident is a tightrope walker."
        ),
        TriviaModel(
            8,
            "Only two national flags have the color purple on them. Which ones are they?"
        ),
        TriviaModel(
            9,
            "More than 800 languages are spoken in Papua New Guinea."
        ),
        TriviaModel(
            10,
            "The majority of polar bears live in Canada—not in the Arctic."
        ),
    )
}