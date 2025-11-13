package AsesmenGanjilRahmania

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rahma.belajar.R
import java.text.DecimalFormat


class KonversiSuhuActivity : AppCompatActivity() {
    lateinit var etSuhuAwal: EditText
    lateinit var spSuhuAwal: Spinner
    lateinit var spSuhuAkhir: Spinner
    lateinit var tvHasilSuhuAkhir: TextView
    lateinit var btKonversi: Button
    lateinit var btBersih: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_konversi_suhu)

        etSuhuAwal = findViewById(R.id.etSuhuAwal)
        spSuhuAwal = findViewById(R.id.spSuhuAwal)
        spSuhuAkhir = findViewById(R.id.spSuhuAkhir)
        tvHasilSuhuAkhir = findViewById(R.id.tvHasilSuhuAkhir)
        btKonversi = findViewById(R.id.btKonversi)
        btBersih = findViewById(R.id.btBersihkan)

        // Listener untuk tombol konversi
        btKonversi.setOnClickListener {
            konversiSuhu()
        }

        // Listener untuk tombol bersihkan
        btBersih.setOnClickListener{
            etSuhuAwal.text.clear()
            tvHasilSuhuAkhir.text = ""
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    fun konversiSuhu(){
        val decimalFormat = DecimalFormat("#.###")
        val suhuAwalString = spSuhuAwal.selectedItem.toString()
        val suhuAkhirString = spSuhuAkhir.selectedItem.toString()

        val suhuAwalText = etSuhuAwal.text.toString()

        //cek kosong atau tidak
        if (suhuAwalText.isEmpty()) {
            etSuhuAwal.error = "Silakan masukkan nilai suhu."
            etSuhuAwal.requestFocus()
            return
        }

        val suhuAwal = suhuAwalText.toDouble()

        if (suhuAwalString == "Celsius"){
            if (suhuAkhirString == "Celsius") {
                val hasilTerformat = decimalFormat.format(suhuAwal)
                tvHasilSuhuAkhir.text = hasilTerformat.toString()
            } else if (suhuAkhirString == "Fahrenheit"){
                val suhuAkhir = (suhuAwal * 9/5) + 32
                val hasilTerformat = decimalFormat.format(suhuAkhir)
                tvHasilSuhuAkhir.text = hasilTerformat.toString()
            } else if (suhuAkhirString == "Kelvin") {
                val suhuAkhir = suhuAwal + 273.15
                val hasilTerformat = decimalFormat.format(suhuAkhir)
                tvHasilSuhuAkhir.text = hasilTerformat.toString()
            }

        }

        if (suhuAwalString == "Fahrenheit"){
            if (suhuAkhirString == "Fahrenheit") {
                val hasilTerformat = decimalFormat.format(suhuAwal)
                tvHasilSuhuAkhir.text = hasilTerformat.toString()
            } else if (suhuAkhirString == "Celsius"){
                val suhuAkhir = (suhuAwal -32) * 5/9
                val hasilTerformat = decimalFormat.format(suhuAkhir)
                tvHasilSuhuAkhir.text = hasilTerformat.toString()
            } else if (suhuAkhirString == "Kelvin"){
                val suhuAkhir = (suhuAwal + 459.67) * 5/9
                val hasilTerformat = decimalFormat.format(suhuAkhir)
                tvHasilSuhuAkhir.text = hasilTerformat.toString()
            }
        }

        if (suhuAwalString == "Kelvin") {
            if (suhuAkhirString == "Kelvin") {
                val hasilTerformat = decimalFormat.format(suhuAwal)
                tvHasilSuhuAkhir.text = hasilTerformat.toString()
            } else if (suhuAkhirString == "Celsius") {
                val suhuAkhir = suhuAwal - 273.15
                val hasilTerformat = decimalFormat.format(suhuAkhir)
                tvHasilSuhuAkhir.text = hasilTerformat.toString()
            } else if (suhuAkhirString == "Fahrenheit") {
                val suhuAkhir = (suhuAwal * 9 / 5) - 459.67
                val hasilTerformat = decimalFormat.format(suhuAkhir)
                tvHasilSuhuAkhir.text = hasilTerformat.toString()
            }
        }

    }
}