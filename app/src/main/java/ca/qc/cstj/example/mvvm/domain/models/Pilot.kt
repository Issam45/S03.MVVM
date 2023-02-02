package ca.qc.cstj.example.mvvm.domain.models

import ca.qc.cstj.example.mvvm.core.Constants
import kotlin.random.Random


data class Pilot(var name: String, var life: Int, var cube: Int = 0) {

    var shield = 10
    var energy: Int = 15

    private var _experience: Int = 0
    val level: Int get() {
        return _experience / Constants.EXPERIENCE_PER_LEVEL
    }
    // val level: Int get() = _experience / 10 // On peut le faire comme sa aussi s'il y a une seul ligne de code

    fun fly(revolutions: Int, isTraining: Boolean = false) {
        if(!isTraining) {

            _experience += revolutions * Random.nextInt(1,2 * level + 1)
            shield -= Random.nextInt(2)
            life -= Random.nextInt(0, 2)
            cube += Random.nextInt(0,2 * level + 1)
        }
        energy -= Random.nextInt(1, 3)
    }

    fun canFly() : Boolean {
        return life > 0 && energy > 0
    }

    fun recharge() {
        // TODO: Add MicroTransaction
        energy = Random.nextInt(0, 10)
        life = 10
    }

}