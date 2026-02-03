package ` oop_00000114579_BrandonTreviso`.week01

fun main (args: Array<String>) {
    val radius: Double = 7.0
    val pi: Double = 3.14

    val area = pi * radius * radius

    println("Radius: $radius, area: $area")

    checkSize(area)
}

fun checkSize(area: Double) {
    if (area > 100) {
        println("This is a Big Circle")
    } else {
        println("This is a Small Circle")
    }
}