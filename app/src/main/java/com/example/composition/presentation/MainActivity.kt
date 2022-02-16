package com.example.composition.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.composition.R
import com.example.composition.domain.entity.GameSettings
import com.example.composition.domain.entity.Question
import com.example.composition.domain.repository.GameRepository
import com.example.composition.domain.usecases.GenerateQuestionUseCase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}