package oop_00000114579_BrandonTreviso.week04

// Gunakan keyword 'open' agar class bisa diwariskan
open class Vehicle(val brand: String) {
    var speed: Int = 0

    // Method juga bersifat final secara default. Gunakan 'open' agar bisa di-override.
    open fun accelerate() {
        speed += 10
        println("$brand melaju. Kecepatan: $speed km/jam")
    }

    open fun honk() {
        println("Beep beep!")
    }
}