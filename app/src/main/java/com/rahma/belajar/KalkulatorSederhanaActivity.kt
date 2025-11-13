package com.rahma.belajar

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class KalkulatorSederhanaActivity : AppCompatActivity() {
    //langkah 1
    //inisialisasi variabel
    //variabel dari komponen yang dibutuhkan
    lateinit var bilangan1:EditText
    lateinit var bilangan2:EditText
    lateinit var operasi:Spinner
    lateinit var hitung:Button

    //langkah 5
    //membuat variabel menampung nilai/bilangan
    var angka1:Double = 0.0
    var angka2:Double = 0.0
    var hasil:Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kalkulator_sederhana)
        //langkah 4
        //memanggil fun init()
        init()

        //langkah 7
        //button hitung di klik
        //memanggil fun hitung
        hitung.setOnClickListener{
            //memanggil fun hitung()
            hitung()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    //langkah 2
    //membuat function
    //untuk sinkron komponen
    fun init(){
        //langkah 3
        //mencocokan variabel dengan komponen
        bilangan1=findViewById(R.id.ETBilangan1)
        bilangan2=findViewById(R.id.ETBilangan2)
        operasi=findViewById(R.id.SpinOpAritmatika)
        hitung=findViewById(R.id.btHitung)
    }

    //langkah 6
    //membuat fun hitung
    //menghitung operasi aritmatika
    fun hitung(){
        angka1 = bilangan1.text.toString().toDoubleOrNull() ?: 0.0
        angka2 = bilangan2.text.toString().toDoubleOrNull() ?: 0.0
        //tambah = posisi 0
        //kurang = posisi 1
        //kali = posisi 2
        //bagi = posisi 3
        angka1=bilangan1.text.toString().toDouble()
        angka2=bilangan2.text.toString().toDouble()
        if(operasi.selectedItemPosition==0){
            //operasi penjumlahan
            hasil = angka1+angka2
        }else if(operasi.selectedItemPosition==1) {
            //operasi pengurangan
            hasil = angka1-angka2
        }else if(operasi.selectedItemPosition==2) {
            //operasi perkalian
            hasil = angka1*angka2
        }else if(operasi.selectedItemPosition==3) {
        //operasi pembagian
        hasil = angka1/angka2
        }else{
        hasil=0.0
        }
        //toast
        Toast.makeText(this,"Hasil = $hasil ",Toast.LENGTH_SHORT).show()
        //snackbar
    }
}   