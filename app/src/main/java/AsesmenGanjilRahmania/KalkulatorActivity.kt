package AsesmenGanjilRahmania

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rahma.belajar.R
import java.text.DecimalFormat

class KalkulatorActivity : AppCompatActivity() {
    //langkah 1
    //deklarasi variabel
    // komponen dan tipe data
    //variabel global
    lateinit var etInput: EditText
    lateinit var btclear: Button
    lateinit var hapus: Button
    lateinit var btpersen: Button
    lateinit var btbagi: Button
    lateinit var bt7: Button
    lateinit var bt8: Button
    lateinit var bt9: Button
    lateinit var btkali: Button
    lateinit var bt4: Button
    lateinit var bt5: Button
    lateinit var bt6: Button
    lateinit var btkurang: Button
    lateinit var bt1: Button
    lateinit var bt2: Button
    lateinit var bt3: Button
    lateinit var bttambah: Button
    lateinit var negatif: Button
    lateinit var btnol: Button
    lateinit var btkoma: Button
    lateinit var bthasil: Button
    var NilaiAwal: Double = 0.0
    var aksi: String = ""
    var koma: Boolean = false

    //on create fungsi yg pasti ada dan pertama kali dipanggil ketika aplikasi dijalankan
    //fun = function

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kalkulator)
        //langkah 3
        init()
        pencet()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun IsiData() {
        if (etInput.text.isNotEmpty()) {
            NilaiAwal = etInput.text.toString().toDouble()
            etInput.text.clear()
        } else {
            NilaiAwal = 0.0
        }
    }

    //langkah 2
    // fun init() digunakan untuk mengisikan lateinit yang sudah dibuat pada langkah 1
    fun init() {
        btclear = findViewById(R.id.btclear)
        negatif = findViewById(R.id.negatif)
        btnol = findViewById(R.id.btnol)
        bt1 = findViewById(R.id.bt1)
        bt2 = findViewById(R.id.bt2)
        bt3 = findViewById(R.id.bt3)
        bt4 = findViewById(R.id.bt4)
        bt5 = findViewById(R.id.bt5)
        bt6 = findViewById(R.id.bt6)
        bt7 = findViewById(R.id.bt7)
        bt8 = findViewById(R.id.bt8)
        bt9 = findViewById(R.id.bt9)
        //
        btbagi = findViewById(R.id.btbagi)
        btkali = findViewById(R.id.btkali)
        btkurang = findViewById(R.id.btkurang)
        bttambah = findViewById(R.id.bttambah)
        hapus = findViewById(R.id.hapus)
        btpersen = findViewById(R.id.btpersen)
        etInput = findViewById(R.id.etInput)
        btkoma = findViewById(R.id.btkoma)
        bthasil = findViewById(R.id.bthasil)
    }

    //langkah 4 digunakan untuk event on cliick listener
    fun pencet() {
        btclear.setOnClickListener {
            koma = false
            aksi = ""
            etInput.text.clear()
        }
        hapus.setOnClickListener {
            if (etInput.text.isNotEmpty()) {
                val currentText = etInput.text.toString()
                etInput.setText(currentText.substring(0, currentText.length - 1))
            }
        }
        negatif.setOnClickListener {
            if (etInput.text.isNotEmpty()) {
                etInput.setText(
                    "${-1 * etInput.text.toString().toDouble()}"
                )
            }
        }
        bt1.setOnClickListener {
            if (koma) {
                etInput.setText("0.1")
            } else {
                etInput.setText("${etInput.text}1")
            }
        }
        bt2.setOnClickListener {
            if (koma) {
                etInput.setText("0.2")
            } else {
                etInput.setText("${etInput.text}2")
            }
        }
        bt3.setOnClickListener {
            if (koma) {
                etInput.setText("0.3")
            } else {
                etInput.setText("${etInput.text}3")
            }
        }
        bt4.setOnClickListener {
            if (koma) {
                etInput.setText("0.4")
            } else {
                etInput.setText("${etInput.text}4")
            }
        }
        bt5.setOnClickListener {
            if (koma) {
                etInput.setText("0.5")
            } else {
                etInput.setText("${etInput.text}5")
            }
        }
        bt6.setOnClickListener {
            if (koma) {
                etInput.setText("0.6")
            } else {
                etInput.setText("${etInput.text}6")
            }
        }
        bt7.setOnClickListener {
            if (koma) {
                etInput.setText("0.7")
            } else {
                etInput.setText("${etInput.text}7")
            }
        }
        bt8.setOnClickListener {
            if (koma) {
                etInput.setText("0.8")
            } else {
                etInput.setText("${etInput.text}8")
            }
        }
        bt9.setOnClickListener {
            if (koma) {
                etInput.setText("0.9")
            } else {
                etInput.setText("${etInput.text}9")
            }
        }
        btnol.setOnClickListener {
            etInput.setText("${etInput.text}0")
        }
        btkoma.setOnClickListener {
            if (etInput.text.isNotEmpty()) {
                etInput.setText("${etInput.text}.")
            } else {
                koma = true
            }
        }
        bttambah.setOnClickListener {
            IsiData()
            aksi = "tambah"
        }
        btkurang.setOnClickListener {
            IsiData()
            aksi = "kurang"
        }
        btbagi.setOnClickListener {
            IsiData()
            aksi = "bagi"
        }
        btkali.setOnClickListener {
            IsiData()
            aksi = "kali"
        }
        btpersen.setOnClickListener {
            IsiData()
            aksi = "persen"
        }
        btpersen.setOnClickListener {
            if (etInput.text.isNotEmpty()) {
                try {
                    val currentValue = etInput.text.toString().replace(',', '.').toDouble()

                    if (aksi.isNotEmpty() && NilaiAwal != 0.0) {
                        when (aksi) {
                            "tambah" -> {
                                val persenValue = NilaiAwal * (currentValue / 100)
                                etInput.setText(persenValue.toString())
                            }

                            "kurang" -> {
                                val persenValue = NilaiAwal * (currentValue / 100)
                                etInput.setText(persenValue.toString())
                            }

                            "kali" -> {
                                val persenValue = currentValue / 100
                                etInput.setText(persenValue.toString())
                            }

                            "bagi" -> {
                                val persenValue = currentValue / 100
                                etInput.setText(persenValue.toString())
                            }
                        }
                    } else {
                        val persenValue = currentValue / 100
                        etInput.setText(persenValue.toString())
                    }
                } catch (e: NumberFormatException) {
                    etInput.setText("Error")
                }
            }
        }
        bthasil.setOnClickListener {
            if (aksi.isNotEmpty()) {
                val decimalFormat = DecimalFormat("#.###")
                if (etInput.text.isNotEmpty()) {
                    val inputNumber = etInput.text.toString().toDouble()
                    val hasilPerhitungan: Double

                    when (aksi) {
                        "tambah" -> {
                            hasilPerhitungan = NilaiAwal + inputNumber
                        }

                        "kurang" -> {
                            hasilPerhitungan = NilaiAwal - inputNumber
                        }

                        "bagi" -> {
                            hasilPerhitungan = NilaiAwal / inputNumber
                        }

                        "kali" -> {
                            hasilPerhitungan = NilaiAwal * inputNumber
                        }

                        else -> return@setOnClickListener
                    }

                    val hasilTerformat = decimalFormat.format(hasilPerhitungan)
                    etInput.setText(hasilTerformat)

                    NilaiAwal = hasilPerhitungan
                    aksi = ""
                }
            }
        }

    }
}