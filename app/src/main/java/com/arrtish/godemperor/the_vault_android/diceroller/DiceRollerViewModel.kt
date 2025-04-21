package com.arrtish.godemperor.the_vault_android.diceroller

import kotlin.random.Random

class DiceRollerViewModel {

    fun rollDice(numberOfDice: Int, diceType: DiceType): Pair<Any, DiceType> {
        if (numberOfDice <= 0) {
            // Handle invalid number of dice
            return Pair("Invalid number of dice", diceType)
        }

        return if (numberOfDice == 1) {
            // Return just the single value when 1 die
            val result = Random.nextInt(1, diceType.maxValue + 1)
            Pair(result, diceType)
        } else {
            // Return the list of values and their sum when more than 1 die
            val results = List(numberOfDice) {
                Random.nextInt(1, diceType.maxValue + 1)
            }
            val sum = results.sum()
            Pair(Pair(results, sum), diceType)
        }
    }
}
