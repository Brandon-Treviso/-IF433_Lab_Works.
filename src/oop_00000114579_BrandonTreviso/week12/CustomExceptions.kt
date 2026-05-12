package oop_00000114579_BrandonTreviso.week12

// Custom exception dengan membawa data tambahan
class InsufficientFundsException(
    val amount: Double,
    val balance: Double
): Exception("Attempted $amount, balance: $balance")
