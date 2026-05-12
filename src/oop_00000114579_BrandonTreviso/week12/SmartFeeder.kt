package oop_00000114579_BrandonTreviso.week12

fun dispenseKibble(
    requestedGram: Int,
    availableGram: Int,
    isJammed: Boolean
): Int {

    require(requestedGram > 0) {
        "Porsi kibble harus lebih dari 0 gr"
    }

    if (isJammed) {
        throw DispenserJamException()
    }

    if (requestedGram > availableGram) {
        throw FoodEmptyException(requestedGram, availableGram)
    }

    println("Kibble berhasil dikeluarkan!")


    return availableGram - requestedGram
}

fun main() {

    var currentKibbleStock = 50

    println("\n=== Jadwal Makan Pagi ===")

    try {

        currentKibbleStock = dispenseKibble(
            requestedGram = 80,
            availableGram = currentKibbleStock,
            isJammed = false
        )

    } catch (e: DispenserJamException) {

        println("Error Dispenser: ${e.message}")

    } catch (e: FoodEmptyException) {

        println("Error Stok: ${e.message}")

    } catch (e: Exception) {

        println("Terjadi kesalahan umum: ${e.message}")
    } finally {
        println("Siklus pengecekan dispenser pagi selesai.")
    }

    println()
    println("\n=== Jadwal Makan Sore ===")

    runCatching {

        dispenseKibble(
            requestedGram = 30,
            availableGram = 1000,
            isJammed = false
        )

    }
}