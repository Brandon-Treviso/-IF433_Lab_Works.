package oop_00000114579_BrandonTreviso.week03

class Weapon(
    val name: String
) {

    var damage: Int = 0
        set(value) {

            if (value < 0) {
                println("Damage tidak boleh negatif!")
                return
            }

            if (value > 1000) {
                println("Damage kebesaran! Diset ke 1000.")
                field = 1000
                return
            }

            field = value
        }

    val tier: String
        get() = when {
            damage > 800 -> "Legendary"
            damage > 500 -> "Epic"
            else -> "Common"
        }
}
