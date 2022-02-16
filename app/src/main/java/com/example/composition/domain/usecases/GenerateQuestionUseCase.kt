package com.example.composition.domain.usecases

import com.example.composition.domain.entity.Question
import com.example.composition.domain.repository.GameRepository

class GenerateQuestionUseCase(private val repository: GameRepository) {

    private companion object {
        const val COUNT_OF_OPTIONS = 6
    }

    operator fun invoke(maxSum: Int): Question {
        return repository.generateQuestion(maxSum, COUNT_OF_OPTIONS)
    }

}