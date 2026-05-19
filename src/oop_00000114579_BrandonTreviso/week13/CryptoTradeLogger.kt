package oop_00000114579_BrandonTreviso.week13

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