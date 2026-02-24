package oop_00000114579_BrandonTreviso.week04

open class Employee(val name: String, val baseSalary: Int){
    open fun work() {
        println("$name sedang bekerja.")
    }
    open fun calculateBonus(): Int {
        return (baseSalary * 0.10).toInt()
    }
}