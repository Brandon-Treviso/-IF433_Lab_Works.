package oop_00000114579_BrandonTreviso.week02

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("--- APLIKASI PMB UMN ---")

    print("Masukkan Nama: ")
    val name = scanner.nextLine()

    print("Masukkan NIM (Wajib 5 Karakter): ")
    val nim = scanner.next()

    scanner.nextLine()

    if (nim.length != 5) {
        println("ERROR: Pendaftaran dibatalkan. NIM harus 5 karakter!")
    } else {
        print("Masukkan Jurusan: ")
        val major = scanner.nextLine()

        val s1 = Student(name, nim, major)
        println("Status: Pendaftaran Selesai.")
    }
    print("Pilih Jalur (1. Reguler, 2. Umum): ")
    val type = scanner.nextInt()
    scanner.nextLine() // Consume newline

    if (type == 1) {
        print("Masukkan Jurusan: ")
        val major = scanner.nextLine()
        // Memanggil Primary Constructor
        val s1 = Student(name, nim, major)
        println("Terdaftar di: ${s1.major} dengan GPA awal ${s1.gpa}")
    } else if (type == 2) {

        val s2 = Student (name, nim)
        println("Terdaftar di: ${s2.major} dengan GPA awal ${s2.gpa}")
    } else {
        println("Pilihan ngawur, pendaftaran batal!")
    }
    println("\n--- SISTEM PEMINJAMAN BUKU ---")

    print("Judul Buku: ")
    val title = scanner.nextLine()

    print("Nama Peminjam: ")
    val borrower = scanner.nextLine()

    print("Lama Pinjam (hari): ")
    var duration = scanner.nextInt()
    scanner.nextLine()

    if (duration < 0) duration = 1

    val loan = Loan(title, borrower, duration)
    println("Total Denda: Rp ${loan.calculateFine()}")

    println("\n--- GAME ---")

    print("Nama Hero: ")
    val heroName = scanner.nextLine()

    print("Base Damage Hero: ")
    val baseDamage = scanner.nextInt()
    scanner.nextLine()

    val hero = Hero(heroName, baseDamage)
    var enemyHp = 100

    while (hero.isAlive() && enemyHp > 0) {
        println("\n1. Serang")
        println("2. Kabur")
        print("Pilih: ")
        val choice = scanner.nextLine()

        if (choice == "1") {
            enemyHp -= hero.baseDamage
            if (enemyHp <  0) enemyHp = 0

            if (enemyHp > 0) {
                val enemyDamage = (10..20).random()
                hero.takeDamage (enemyDamage)
                println("Musuh Menyerang balik!!!")
                println("HP Hero sekarang: ${hero.hp}")
            }
        } else if (choice == "2") {
            println("Hero run awayyy...")
            break
        } else {
            println("Pilihan tidak valid!")
        }
    }
    if (hero.isAlive() && enemyHp <= 0) {
        println("Hero Win!")
    } else if (!hero.isAlive()) {
        println("Hero Lose!")
    } else {
        println("Pertarungan dihentikan!")
    }
}
