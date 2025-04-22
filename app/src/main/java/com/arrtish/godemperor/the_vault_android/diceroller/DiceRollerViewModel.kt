package com.arrtish.godemperor.the_vault_android.diceroller

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DiceRollerViewModel : ViewModel() {

    fun rollDice(numberOfDice: Int, diceType: DiceType): Pair<Any, Int> {
        if (numberOfDice <= 0) {
            // Handle invalid number of dice
            return Pair("Invalid number of dice", numberOfDice)
        }

        return if (numberOfDice == 1) {
            // Return just the single value when 1 die
            val result = Random.nextInt(1, diceType.maxValue + 1)
            Pair(result, result)
        } else {
            // Return the list of values and their sum when more than 1 die
            val results = List(numberOfDice) {
                Random.nextInt(1, diceType.maxValue + 1)
            }
            val sum = results.sum()
            Pair(results, sum)
        }
    }
}
