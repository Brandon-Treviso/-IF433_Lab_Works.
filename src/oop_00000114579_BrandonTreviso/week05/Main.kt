package oop_00000114579_BrandonTreviso.week05

fun main() {
    val dosen1 = Dosen("Pak Alex", "0123456")
    val admin1 = Admin("Bu Siti")

    // Polymorphic Collection: List yang berisi tipe Parent, tapi isinya objek Anak
    val daftarPegawai: List<Pegawai> = listOf(dosen1, admin1)

    println("=== AKTIVITAS PEGAWAI ===")
    for (pegawai in daftarPegawai) {
        // Pemanggilan Runtime Polymorphism
        pegawai.bekerja()

        // pegawai.mengajar() // INI AKAN ERROR karena tipe referensinya adalah Pegawai
        // Smart Casting dengan is dan when
        when (pegawai) {
            is Dosen -> {
                println("=> Terdeteksi sebagai Dosen (NIDN: ${pegawai.nidn})")
                pegawai.mengajar() // Smart cast ! Tidak perlu manual casting (as)
            }

            is Admin -> {
                println("=> Terdeteksi sebagai Admin")
                pegawai.doAdminWork()
            }
        }
        println("-------------------------------")
    }

    val mathHelper = MathHelper()

    println("Luas Persegi: ${mathHelper.hitungLuas(5)}")
    println("Luas Persegi Panjang: ${mathHelper.hitungLuas(4, 6)}")
    println("Luas Lingkaran: ${mathHelper.hitungLuas(7.0)}")

    println("--------------------------------------")
    val eWallet = EWallet("Brandon", 50000.0)
    val creditCard = CreditCard("Brandon", 100000.0)

    val paymentMethods: List<PaymentMethod> = listOf(eWallet, creditCard)

    for (payment in paymentMethods) {

        println("Metode pembayaran: ${payment.accountName}")
        payment.processPayment(75000.0)

        if (payment is EWallet) {
            println("Saldo kurang, melakukan top up otomatis...")
            payment.topUp(50000.0)
            payment.processPayment(75000.0)
        }


        println()
    }
}