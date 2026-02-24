package oop_00000114579_BrandonTreviso.week04

fun main() {
    println("--- Testing Vehicle ---")
    val generalVehicle = Vehicle("Sepeda Onthel")
    generalVehicle.honk()
    generalVehicle.accelerate()

    println("\n--- Testing Car ---")
    val myCar = Car("Toyota", 4)
    myCar.openTrunk() // Memanggil method milik sendiri
    myCar.honk() // Memanggil method yang sudah di-override
    myCar.accelerate() // Memanggil gabungan method Parent dan Child

    println("\n--- Tes ElecticCar ---")

    val electricCar = ElectricCar("Wuling", 4, 100)
    electricCar.accelerate()
    electricCar.honk()
    electricCar.openTrunk()

    println("\n--- Inisiasi Developer dan Manager ---")

    println("\n--- Manager ---")
    val manager = Manager("Brandon", 50000000)
    manager.work()
    println("Bonus Manager: ${manager.calculateBonus()}")

    println("\n --- Developer ---")
    val developer = Developer("Udin", 4000000, "JavaScript")
    developer.work()
    println("Bonus Developer: ${developer.calculateBonus()}")
}