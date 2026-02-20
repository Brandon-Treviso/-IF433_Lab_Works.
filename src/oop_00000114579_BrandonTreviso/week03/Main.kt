package oop_00000114579_BrandonTreviso.week03

fun main() {
    val e = Employee("Budi")

    // 1. Test Validasi Salary
    e.salary = -1000 // Harunsya Print Error
    e.salary = 5000000
    println("Gaji: ${e.salary}")

    // 2. Test Encapsulation
    e.increasePerformance()
    // e.performanceRating = 5 // Coba uncomment, pasti Merah (Error)

    // 3. Test Computed Property
    println("Pajak yang harus dibayar: ${e.tax}")

    println("\n--- WEAPON TESTING ---")

    val sword = Weapon("Sovereign")

    sword.damage = -50
    sword.damage = 9999

    println("Weapon: ${sword.name}")
    println("Damage: ${sword.damage}")
    println("Tier: ${sword.tier}")
}