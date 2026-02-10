package oop_00000114579_BrandonTreviso.week02

class Student (
    val name: String,
    val nim: String,
    var gpa: Double = 0.0, // <-- Default Argument
    var major: String
){
    init {
        // Validasi Sederhana: Cek panjang NIM
        if (nim.length != 5) {
            println("WARNING: Objek tercipta dengan NIM ($nim) yang tidak 	valid!")
            println("Data mahasiswa $name mungkin akan bermasalah di system.")
        } else {
            println("LOG: Objek Student $name berhasil dialokasikan di Memory.")
        }
    }
    constructor(name: String, nim: String) : this(name, nim, "Non-Matriculated") {
        println("LOG: Menggunakan constructor jalur umum (Tanpa Jurusan).")
    }
}