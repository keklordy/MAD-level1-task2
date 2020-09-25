package com.example.madlevel1task2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.madlevel1task2.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
            checkAnswer()
        }
    }

    private fun checkAnswer() {
        var correctAnswers: Int = 0
        val maxCorrectAnswers: Int = 4

        val filledInAnswers = arrayOf<String>(
            binding.answerOne.text.toString().toUpperCase(Locale.ROOT),
            binding.answerTwo.text.toString().toUpperCase(Locale.ROOT),
            binding.answerThree.text.toString().toUpperCase(Locale.ROOT),
            binding.answerFour.text.toString().toUpperCase(Locale.ROOT)
        )

        // checks if the filled in answers are right
        for (x in filledInAnswers.indices) {
            if (x == 0 && filledInAnswers[x] == getString(R.string.value_true)) {
                correctAnswers++
            } else if (x != 0 && filledInAnswers[x] == getString(R.string.value_false)) {
                correctAnswers++
            }
        }

        //chooses which message to send
        when (correctAnswers) {
            maxCorrectAnswers -> allAnswersCorrect()
            else -> Toast.makeText(
                this,
                getString(R.string.correct_answers, correctAnswers),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun allAnswersCorrect() {
        Toast.makeText(this, getString(R.string.all_correct), Toast.LENGTH_SHORT).show()
    }
}