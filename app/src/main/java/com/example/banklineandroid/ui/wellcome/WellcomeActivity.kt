package com.example.banklineandroid.ui.wellcome


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banklineandroid.databinding.ActivityWellcomeBinding
import com.example.banklineandroid.ui.domain.Correntista
import com.example.banklineandroid.ui.statement.ExtratoActivity

class WellcomeActivity : AppCompatActivity() {
    private val bidding by lazy {
         ActivityWellcomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bidding.root)

        bidding.idBtnBuscar.setOnClickListener(){
            val idCorrentista = bidding.idEdtIdConta.text.toString().toInt()
             val correntistaNumero = Correntista(idCorrentista)
            var intent = Intent(this,ExtratoActivity::class.java).apply {

                putExtra(ExtratoActivity.EXTRA_CORRENTISTA_ID,correntistaNumero)
            }
            startActivity(intent)
        }


    }
}