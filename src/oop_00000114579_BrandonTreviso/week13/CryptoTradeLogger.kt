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

    val data = line.split(",")

    return TradeRecord(
        data[0].toInt(),
        data[1],
        data[2],
        data[3].toDouble(),
        data[4].toDouble()
    )
}