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

interface PricingStrategy {
    fun calculate(price: Double): Double
}

class VipPricing : PricingStrategy {

    override fun calculate(price: Double): Double {
        return price * 0.8
    }
}

class RegularPricing : PricingStrategy {

    override fun calculate(price: Double): Double {
        return price * 0.9
    }
}

class GuestPricing : PricingStrategy {

    override fun calculate(price: Double): Double {
        return price
    }
}

class SafeOrderProcessor(
    private val repository: OrderRepository,
    private val notifier: NotificationService
) {

    fun processOrder(
        strategy: PricingStrategy,
        customerEmail: String,
        price: Double
    ) {

        val finalPrice = strategy.calculate(price)

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
        VipPricing(),
        "brandon@gmail.com",
        100000.0
    )

    processor.processOrder(
        RegularPricing(),
        "user@gmail.com",
        50000.0
    )

    processor.processOrder(
        GuestPricing(),
        "guest@gmail.com",
        30000.0
    )
}