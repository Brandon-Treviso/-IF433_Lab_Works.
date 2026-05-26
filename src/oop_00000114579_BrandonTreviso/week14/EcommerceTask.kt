package oop_00000114579_BrandonTreviso.week14

import java.io.File

interface OrderRepository {
    fun saveOrder(data: String)
}

class CsvOrderRepository : OrderRepository {

    override fun saveOrder(data: String) {

        File("orders.csv")
            .bufferedWriter()
            .use { writer ->
                writer.append(data)
                writer.newLine()
            }

        println("Order saved to CSV")
    }
}

interface NotificationService {
    fun sendNotification(email: String)
}

class EmailNotifier : NotificationService {

    override fun sendNotification(email: String) {
        println("Sending email notification to $email")
    }
}

class SafeOrderProcessor(
    private val repository: OrderRepository,
    private val notifier: NotificationService
) {

    fun processOrder(
        customerType: String,
        customerEmail: String,
        price: Double
    ) {

        val finalPrice = when (customerType) {
            "VIP" -> price * 0.8
            "REGULAR" -> price * 0.9
            else -> price
        }

        val orderData =
            "Email: $customerEmail, Total: $finalPrice"

        repository.saveOrder(orderData)

        notifier.sendNotification(customerEmail)

        println("Final Price: $finalPrice")
    }
}

fun main() {

    val processor = SafeOrderProcessor(
        CsvOrderRepository(),
        EmailNotifier()
    )

    processor.processOrder(
        "VIP",
        "brandon@gmail.com",
        100000.0
    )
}