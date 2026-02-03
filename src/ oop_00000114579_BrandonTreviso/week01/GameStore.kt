package ` oop_00000114579_BrandonTreviso`.week01

fun main() {
    val gameTitle = "Black Myth Wukong"
    val price = 750000

    val finalPrice = calculateDiscount(price)

    printReceipt (title = gameTitle, finalPrice = finalPrice)
}

fun calculateDiscount(price: Int) =
    if (price > 500000)
        price - (price * 20 / 100)
    else
        price - (price * 10 / 100)

fun printReceipt (title: String, finalPrice: Int) {
    println("Judul Game : $title")
    println("Harga Akhir: Rp. $finalPrice")
}