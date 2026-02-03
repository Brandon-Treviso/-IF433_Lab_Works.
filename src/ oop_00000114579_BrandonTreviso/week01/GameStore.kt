package ` oop_00000114579_BrandonTreviso`.week01

fun main() {
    val gameTitle = "Black Myth Wukong"
    val price = 750000

    val finalPrice = calculateDiscount(price)
}

fun calculateDiscount(price: Int) =
    if (price > 500000)
        price - (price * 20 / 100)
    else
        price - (price * 10 / 100)