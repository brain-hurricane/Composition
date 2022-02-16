package com.example.composition.data

import com.example.composition.domain.entity.GameSettings
import com.example.composition.domain.entity.Level
import com.example.composition.domain.entity.Question
import com.example.composition.domain.repository.GameRepository
import kotlin.collections.HashSet
import kotlin.math.max
import kotlin.random.Random

class GameRepositoryImpl: GameRepository {

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(2, maxSumValue + 1)
        val visibleNumber = Random.nextInt(1, sum)
        val rightAnswer = sum - visibleNumber
        val from = max(1, rightAnswer - countOfOptions)
        val to = rightAnswer + countOfOptions + 1
        val options = HashSet<Int>()
        options.add(rightAnswer)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, rightAnswer, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> GameSettings(50, 5, 50, 20)
            Level.EASY -> GameSettings(30, 5, 70, 30)
            Level.NORMAL -> GameSettings(60, 10, 80, 20)
            Level.HARD -> GameSettings(100, 20, 90, 10)
        }
    }
}