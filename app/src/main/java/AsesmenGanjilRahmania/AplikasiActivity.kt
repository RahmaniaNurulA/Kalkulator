package AsesmenGanjilRahmania

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rahma.belajar.R
import kotlin.io.encoding.Base64

class aplikasiActivity : AppCompatActivity() {
    lateinit var cardform : CardView
    lateinit var cardkalkulator :CardView
    lateinit var cardKonversi : CardView
    lateinit var cardProfil : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_aplikasi)
        init()
        tekan()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun init(){
        cardform = findViewById(R.id.cardform)
        cardkalkulator = findViewById(R.id.cardkalkulator)
        cardProfil = findViewById(R.id.cardProfil)
        cardKonversi = findViewById(R.id.cardKonversi)
    }
    fun tekan(){
        cardform.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        cardkalkulator.setOnClickListener{
            val intent = Intent(this, KalkulatorActivity::class.java)
            startActivity(intent)
        }
        cardKonversi.setOnClickListener{
            val intent = Intent(this, KonversiSuhuActivity::class.java)
            startActivity(intent)
        }
        cardProfil.setOnClickListener{
            val intent = Intent(this, Profile2::class.java)
            startActivity(intent)
        }
    }
}