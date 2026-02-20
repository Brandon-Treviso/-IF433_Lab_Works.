package oop_00000114579_BrandonTreviso.week03

class Player (
    val username: String
) {
    private var xp: Int = 0

    val level: Int
    get() = (xp / 100) + 1

    fun addXp(amount: Int) {

        if (amount <= 0) {
            println("XP harus positif!")
            return
        }

        val oldlevel = level
        xp += amount
        val newLevel = level

        if (newLevel > oldlevel) {
            println("Level Up! Selamat $username naik ke level $newLevel")
        }
    }
}