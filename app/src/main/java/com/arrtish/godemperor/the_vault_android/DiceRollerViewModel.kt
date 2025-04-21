package com.arrtish.godemperor.thevault

import kotlin.random.Random

class DiceRollerViewModel {

    // Function to roll a dice and return the result along with the DiceType
    fun rollDice(diceType: DiceType): Pair<Int, DiceType> {
        val rolledResult = Random.nextInt(1, diceType.maxValue + 1) // Generate a random number for the dice roll
        return Pair(rolledResult, diceType) // Return the result and the DiceType
    }

}