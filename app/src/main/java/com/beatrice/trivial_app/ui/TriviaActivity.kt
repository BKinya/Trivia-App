package com.beatrice.trivial_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.beatrice.architectureComponets.R
import com.beatrice.trivial_app.data.TriviaModel

class TriviaActivity : AppCompatActivity() {
    private val triviaViewModel: TriviaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saveTrivia()
    }
    // TODO: Save the records if don't exist in the database
    // TODO: When you click the button it reads from the database ans shows thta

    private fun saveTrivia() {
        triviaViewModel.saveTrivia(trivia, this)
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
            "Only two national flags have the color purple on them. Which ones are they"
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