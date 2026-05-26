package oop_00000114579_BrandonTreviso.week14

class UserValidator {
    fun validate(user: User): Boolean = user.email.contains("@") && user.age >= 18
}

class UserRepository {
    fun save(user: User) {
        println("Saving user: ${user.name} to Database")
    }
}

class EmailService {
    fun sendWelcome(user: User) {
        println("Welcome email -> ${user.email}")
    }
}
