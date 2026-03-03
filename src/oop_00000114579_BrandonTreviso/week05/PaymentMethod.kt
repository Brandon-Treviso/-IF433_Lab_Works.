package oop_00000114579_BrandonTreviso.week05

abstract class PaymentMethod(val accountName: String) {
    abstract fun processPayment(amount: Double)
}