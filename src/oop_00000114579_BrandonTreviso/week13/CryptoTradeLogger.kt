package oop_00000114579_BrandonTreviso.week13

import java.io.File
import java.io.FileNotFoundException

data class TradeRecord(
    val id: Int,
    val symbol: String,
    val type: String,
    val margin: Double,
    val pnl: Double
)

fun TradeRecord.toCsv(): String {
    return "$id,$symbol,$type,$margin,$pnl"
}

fun fromCsvTrade(line: String): TradeRecord? {

    return try {

        val data = line.split(",")

        TradeRecord(
            data[0].toInt(),
            data[1],
            data[2],
            data[3].toDouble(),
            data[4].toDouble()
        )

    } catch (e: Exception) {

        println("(Log) Data korup diabaikan: $line")
        null
    }
}

fun saveTrades(trades: List<TradeRecord>, path: String) {

    File(path).printWriter().use { writer ->

        trades.forEach {
            writer.println(it.toCsv())
        }
    }
}

fun loadTrades(path: String): List<TradeRecord> {

    return try {

        File(path)
            .readLines()
            .mapNotNull {
                fromCsvTrade(it)
            }

    } catch (e: FileNotFoundException) {
        emptyList()
    }
}

fun main() {

    val trades = listOf(

        TradeRecord(
            1,
            "BTCUSDT",
            "Long",
            150.0,
            35.5
        ),

        TradeRecord(
            2,
            "ETHUSDT",
            "Short",
            100.0,
            -10.0
        ),

        TradeRecord(
            3,
            "SOLUSDT",
            "Long",
            80.0,
            20.0
        )
    )

    saveTrades(trades, "crypto_trades.csv")
    File("crypto_trades.csv")
    .appendText("CORRUPT_ID,DOGEUSDT,Hold,XX,YY\n")

    val loadedData = loadTrades("crypto_trades.csv")

    val totalPnl = loadedData.sumOf {
        it.pnl
    }

    println("=== VALID TRADE DATA ===")

    loadedData.forEach {
        println(it)
    }

    println("==== TOTAL PnL BERSIH: $totalPnl ====")
}
